package Piece;

import Game.Box;
import Game.Player;
import Game.chessBoard; // Adjusted import statement

public class Pawn implements Piece {
    private Box box;
    private Player player;
    private boolean isWhite;
    private int column;
    private int row;

    public Pawn(Box box, Player player, boolean isWhite, int column, int row) {
        this.box = box;
        this.player = player;
        this.isWhite = isWhite;
        this.column = column;
        this.row = row;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Box getBox() {
        return box;
    }

    @Override
    public void setBox(Box destinationBox) {
        this.box = destinationBox;
    }

    // Assuming Game.Type is an enum, otherwise, adjust the return type accordingly
    public Game.Type getType() {
        return Game.Type.PAWN;
    }

    @Override
    public boolean isValidMove(Box destinationBox) {
        int destXPosition = destinationBox.getXPosition(); // Accessing the xPosition property directly
        int destYPosition = destinationBox.getYPosition(); // Accessing the yPosition property directly

        // Forward movement for white pawn
        if (isWhite && destXPosition == column && destYPosition == row - 1) {
            return true;
        }

        // Forward movement for black pawn
        if (!isWhite && destXPosition == column && destYPosition == row + 1) {
            return true;
        }

        // First move for white pawn
        if (isWhite && row == 6 && destXPosition == column && destYPosition == row - 2) {
            return true;
        }

        // First move for black pawn
        if (!isWhite && row == 1 && destXPosition == column && destYPosition == row + 2) {
            return true;
        }

        return false;
    }

    public boolean pawnCanCapture(Box destinationBox) {
        int destXPosition = destinationBox.getXPosition(); // Accessing the xPosition property directly
        int destYPosition = destinationBox.getYPosition(); // Accessing the yPosition property directly

        // Pawn captures diagonally
        if (isWhite && Math.abs(destXPosition - column) == 1 && destYPosition == row - 1) {
            return true;
        }

        if (!isWhite && Math.abs(destXPosition - column) == 1 && destYPosition == row + 1) {
            return true;
        }

        return false;
    }

    public boolean pawnCanMoveTwo(Box destinationBox) {
        // Pawn moves forward two squares on its first move
        if (isWhite && row == 6 && destinationBox.getXPosition() == column && destinationBox.getYPosition() == row - 2) {
            return true;
        }

        if (!isWhite && row == 1 && destinationBox.getXPosition() == column && destinationBox.getYPosition() == row + 2) {
            return true;
        }

        return false;
    }

    public void promotion(String newPieceType, chessBoard board) { // Adjusted parameter type
        if ((isWhite && row == 0) || (!isWhite && row == 7)) {
            Piece newPiece = null;
            switch (newPieceType) {
                case "Queen":
                    newPiece = new Queen(board.getBox(column, row), player); // Assuming Queen constructor is similar to Pawn
                    break;
                case "Rook":
                    newPiece = new Rook(board.getBox(column, row), player); // Assuming Rook constructor is similar to Pawn
                    break;
                // Add cases for other piece types if needed
            }

            if (newPiece != null) {
                board.replacePiece(this, newPiece);
            }
        }
    }
}
