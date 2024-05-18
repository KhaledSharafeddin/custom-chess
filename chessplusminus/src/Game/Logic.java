package Game;

//Logic.java
import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.Collections;

import GUI.ChessBoardGui;
import Piece.Piece;

public class Logic {

    public Logic() {

    }

    // private static boolean inChessBoard(){
    // if(//something here ){

    // return true;
    // }else{
    // return false;
    // }

    // }
    public boolean isCheck(ChessBoardGui board, Player player) {
        // Implementation for check logic
        for (Piece piece : board.getPieceList()) {
            if (piece.getColor() != player.getColor() && piece.isValidMove(player.getKing(board).getBox())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMoveValid(ChessBoardGui board, Piece piece, int newRow, int newCol) {
        // Check if the new position is within the board boundaries
        if (!board.inChessBoard(newRow, newCol)) {
            return false;
        }

        // Check if the destination square is empty or occupied by an enemy piece
        Piece targetPiece = board.getPiece(newRow, newCol);
        if (targetPiece == null || targetPiece.getColor() != piece.getColor()) {
            // Check if the move is valid for the specific piece type (implement logic for
            // each piece type here)
            return validatePieceMove(board, piece, piece.getBox().getYPosition(), piece.getBox().getXPosition(), newRow,
                    newCol);
        }

        return false;
    }

    private static boolean validatePieceMove(ChessBoardGui board, Piece piece, int currentRow, int currentCol,
            int newRow, int newCol) {
        switch (piece.getType()) {
            case PAWN:
                return validatePawnMove(piece.getColor(), currentRow, currentCol, newRow, newCol);
            case KNIGHT:
                return validateKnightMove(currentRow, currentCol, newRow, newCol);
            case BISHOP:
                return validateBishopMove(board, currentRow, currentCol, newRow, newCol);
            case ROOK:
                return validateRookMove(currentRow, currentCol, newRow, newCol);
            case QUEEN:
                return validateQueenMove(board, currentRow, currentCol, newRow, newCol);
            case KING:
                return validateKingMove(piece.getColor(), currentRow, currentCol, newRow, newCol);
        }
        return false;
    }

    private static boolean validatePawnMove(Color color, int currentRow, int currentCol, int newRow, int newCol) {
        int rowDifference = newRow - currentRow;
        int colDifference = Math.abs(newCol - currentCol);

        if (color == Color.WHITE) {
            // White pawns move up the board (decreasing row index)
            if (rowDifference == -1 && colDifference == 0) {
                // Move forward by one square
                return true;
            } else if (rowDifference == -2 && colDifference == 0 && currentRow == 6) {
                // Move forward by two squares from the initial position
                return true;
            } else if (rowDifference == -1 && colDifference == 1) {
                // Capture diagonally
                return true;
            }
        } else if (color == Color.BLACK) {
            // Black pawns move down the board (increasing row index)
            if (rowDifference == 1 && colDifference == 0) {
                // Move forward by one square
                return true;
            } else if (rowDifference == 2 && colDifference == 0 && currentRow == 1) {
                // Move forward by two squares from the initial position
                return true;
            } else if (rowDifference == 1 && colDifference == 1) {
                // Capture diagonally
                return true;
            }
        }

        return false;
    }

    private static boolean validateKnightMove(int currentRow, int currentCol, int newRow, int newCol) {
        int distanceRow = Math.abs(newRow - currentRow);
        int distanceCol = Math.abs(newCol - currentCol);

        // L-shaped movement (two squares in one direction and one square
        // perpendicularly)
        return (distanceRow == 1 && distanceCol == 2) || (distanceRow == 2 && distanceCol == 1);
    }

    private static boolean validateBishopMove(ChessBoardGui board, int currentRow, int currentCol, int newRow,
            int newCol) {
        int distanceRow = Math.abs(newRow - currentRow);
        int distanceCol = Math.abs(newCol - currentCol);

        if (distanceRow != distanceCol) {
            return false; // Not a diagonal move
        }

        // Check if the path between current and new position is clear
        int directionRow = Integer.compare(newRow, currentRow); // -1 for up, 1 for down
        int directionCol = Integer.compare(newCol, currentCol); // -1 for left, 1 for right

        for (int i = 1; i < distanceRow; i++) { // Skip starting and ending squares
            int checkRow = currentRow + i * directionRow;
            int checkCol = currentCol + i * directionCol;

            if (board.getPieceList().stream().anyMatch(
                    piece -> piece.getBox().getYPosition() == checkRow && piece.getBox().getXPosition() == checkCol)) {
                return false; // A piece is blocking the path
            }
        }

        return true;
    }

    private static boolean validateRookMove(int currentRow, int currentCol, int newRow, int newCol) {
        // Rook moves horizontally or vertically
        return (currentRow == newRow || currentCol == newCol);
    }

    private static boolean validateQueenMove(ChessBoardGui board, int currentRow, int currentCol, int newRow,
            int newCol) {
        // Queen moves horizontally, vertically, or diagonally
        return validateRookMove(currentRow, currentCol, newRow, newCol)
                || validateBishopMove(board, currentRow, currentCol, newRow, newCol);
    }

    private static boolean validateKingMove(Color color, int currentRow, int currentCol, int newRow, int newCol) {
        // King moves one square in any direction
        int rowDifference = Math.abs(newRow - currentRow);
        int colDifference = Math.abs(newCol - currentCol);
        return rowDifference <= 1 && colDifference <= 1;
    }

    public void moveTo(Box currentBox, Box destinationBox) {
        Piece piece = currentBox.getPiece();
        if (piece != null && piece.isValidMove(destinationBox)) {
            destinationBox.setPiece(piece);
            currentBox.setPiece(null);
        }
    }
    // public static boolean isPieceCaptured(Piece.Piece piece){
    // Collections.sort(Player.capturedPieces);
    // if(Collections.binarySearch(Player.capturedPieces, piece) != null){
    // return true;
    // }
    // }

}
