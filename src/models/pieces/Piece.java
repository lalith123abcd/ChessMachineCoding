package models.pieces;

import models.Board.Cell;
import models.Helpers.Color;
import models.Helpers.Direction;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private boolean killed;
    private final PieceName pieceName;
    private final Color color;
    private  List<Move> movesDone;

    public Piece(PieceName name,Color color){
        killed=false;
        pieceName=name;
        this.color=color;
        this.movesDone=new ArrayList<>();
    }

    public Color getColor() {
        return color;
    }

    public boolean isKilled() {
        return killed;
    }

    public PieceName getPieceName() {
        return pieceName;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    protected boolean isMovingDiagonally(Cell startingCell, Cell endingCell) {
        return startingCell.getHorizontalDistance(endingCell) == 1 && startingCell.getVerticalDistance(endingCell) == 1;
    }

    protected boolean isMovingHorizontally(Cell startingCell, Cell endingCell) {
        return startingCell.getHorizontalDistance(endingCell) == 1 && startingCell.getVerticalDistance(endingCell) == 0;
    }

    protected boolean isMovingVertically(Cell startingCell, Cell endingCell) {
        return startingCell.getHorizontalDistance(endingCell) == 0 && startingCell.getVerticalDistance(endingCell) == 1;
    }

    protected Direction getMovementDirection(Cell startingCell,Cell endingCell){
        int x= endingCell.getX()-startingCell.getX();
        int y= endingCell.getY()-startingCell.getY();

        if(x==0 && y==0){
            return Direction.NONE;
        }
        if(x==0){
            return y>0 ? Direction.FORWARD_Y:Direction.BACKWARD_Y;
        }
        if(y==0){
            return x>0 ? Direction.FORWARD_X:Direction.BACKWARD_X;
        }
        if(x==1 && y==1){
            return Direction.DIAGONAL_FORWARD_RIGHT;
        }
        if(x==1 && y==-1){
            return Direction.DIAGONAL_BACKWARD_RIGHT;
        }
        if(x==-1 && y==1){
            return Direction.DIAGONAL_FORWARD_LEFT;
        }
        if(x==-1 && y==-1){
            return Direction.DIAGONAL_BACKWARD_LEFT;
        }
        return Direction.NONE;
    }

}
