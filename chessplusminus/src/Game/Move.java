package Game;

import GUI.ChessBoardGui;
import Piece.Piece;

// Move class (assuming it represents a move from a piece to a new position)
public class Move {
    private GUI.ChessBoardGui board;
    private Piece piece;
    private int newRow;
    private int newCol;
    private Box Box;

    public Move(GUI.ChessBoardGui board, Piece piece, int newRow, int newCol) {
        this.board = board;
        this.piece = piece;
        this.newRow = newRow;
        this.newCol = newCol;
    }

    public ChessBoardGui getBoard() {
        return board;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getNewRow() {
        return newRow;
    }

    public int getNewCol() {
        return newCol;
    }

    public Box getNewBox() {
        return new Box(newRow, newCol);
    }
    // Getter methods for board, piece, newRow, and newCol
}