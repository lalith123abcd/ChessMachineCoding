package models.Board;

import models.Helpers.Pair;
import models.pieces.ChessPiece;
import models.pieces.Piece;

import java.util.Optional;

public class Cell {
    private Optional<ChessPiece> piece;

    private final Pair position;

    public Cell(int x,int y) {
        this.position = new Pair(x,y);
        this.piece = Optional.empty();
    }

    public Optional<Piece> getPiece() {
        return piece;
    }

    public boolean hasPiece(){
        return piece.isPresent();
    }


    public void setPiece(Optional<ChessPiece> piece) {
        this.piece = piece;
    }

    public void removePiece(){
        this.piece=Optional.empty();
    }

    public Pair getPosition() {
        return position;
    }

    public int getX(){
        return position.getX();
    }
    public int getY(){
        return position.getY();
    }
    public int getVerticalDistance(Cell cell) {
        return Math.abs(this.getY() - cell.getY());
    }

    public int getHorizontalDistance(Cell cell) {
        return Math.abs(this.getX() - cell.getX());
    }

}
