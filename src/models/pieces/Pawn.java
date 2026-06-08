package models.pieces;

import exceptions.InvalidPieceMoveException;
import models.Board.Cell;
import models.Helpers.Color;
import models.Helpers.Direction;

public class Pawn extends Piece implements ChessPiece{


    public Pawn(PieceName name, Color color){
        super(name,color);
    }
    @Override
    public void makeMove(Cell startingCell, Cell endingCell) {

    }

    @Override
    public boolean canMove(Cell startingCell, Cell endingCell) {
        // 1. If this is the first move then pawn can move one step or two step
        // 2. If this is not the first move then pawn can move only one step
        // 3. If diagonally we have an opposite color piece then pawn can move and kill that piece
        // 4. If diagonally we have an same color piece then pawn can't move
        // 5. If vertically we have a piece then pawn can't move
        // 6. If we have a black pawn then it can move in the negative direction of y-axis and if we have a white pawn
        // then it can move in the positive direction of y-axis

//        if(startingCell.getVerticalDistance(endingCell)>2){
//            throw new InvalidPieceMoveException("Invalid move for pawn");
//        }
//
//        if(!isMovingForTheFirstTime() && startingCell.getHorizontalDistance(endingCell)==2){
//            throw new  InvalidPieceMoveException("Invalid move for pawn");
//        }
//
//        if(isMovingHorizontally(startingCell,endingCell)){
//            throw new InvalidPieceMoveException("Invalid move for pawn");
//        }
//
//        if(endingCell.hasPiece() && !this.isMovingDiagnolly(startingCell,endingCell)){
//            throw new InvalidPieceMoveException("Invalid move for pawn");
//        }

        Direction direction=getMovementDirection(startingCell,endingCell);
        if(!isDirectionValidForPawn(direction)){
            throw new InvalidPieceMoveException("Invalid move for pawn");
        }

        if(isMovingVertically(startingCell,endingCell) && !endingCell.hasPiece()){
            if(startingCell.getVerticalDistance(endingCell)==2 && isMovingForTheFirstTime()){
               //we want to check whether this path is free or not
                return true;
            }
            else if(startingCell.getVerticalDistance(endingCell)==1)return true;
            else return false;
        }

        if(isMovingDiagnolly(startingCell,endingCell) && endingCell.hasPiece() &&
            endingCell.getPiece().get().getColor()!=this.getColor()
        ){
            return true;
        }

    }

    @Override
    public void setKilled(boolean killed) {

    }

    @Override
    public boolean isKilled() {
        return this.isKilled();
    }

    @Override
    public void listPossibleMoves(Cell currentCell) {

    }

    @Override
    public boolean isMovingForTheFirstTime() {
        return false;
    }

    private boolean isMovingDiagnolly(Cell start,Cell end){
        return (start.getHorizontalDistance(end)==1 && start.getVerticalDistance(end)==1);
    }

    private boolean isDirectionValidForPawn(Direction direction){

        if(this.getColor()==Color.WHITE){
            return direction.equals(Direction.FORWARD_Y) ||
                    direction.equals(Direction.DIAGONAL_FORWARD_RIGHT)
                    || direction.equals(Direction.DIAGONAL_FORWARD_LEFT);
        }
        else{
            return direction.equals(Direction.BACKWARD_Y) ||
                    direction.equals(Direction.DIAGONAL_BACKWARD_LEFT)
                    || direction.equals(Direction.DIAGONAL_BACKWARD_RIGHT);
        }
    }
}
