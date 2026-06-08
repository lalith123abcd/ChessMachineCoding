package models.pieces;

import models.Board.Cell;

public interface ChessPiece {

    void makeMove(Cell startingCell,Cell endingCell);

    boolean canMove(Cell startingCell,Cell endingCell);

    void setKilled(boolean killed);

    boolean isKilled();

    void listPossibleMoves(Cell currentCell);

    boolean isMovingForTheFirstTime();
}
