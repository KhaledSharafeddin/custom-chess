package Piece;
//Pawn.java
import Game.Box;
import Game.Player;
import Game.chessBoard;

public class Pawn implements Piece {
    public String type;
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
   
    public Game.Type getType() {
    return Game.Type.PAWN;
    }


    @Override
    public boolean isValidMove(Box destinationBox) {
        int destXPosition = destinationBox.getXPosition();
        int destYPosition = destinationBox.getYPosition(); 

        if (isWhite && destXPosition == column && destYPosition == row - 1) {
            return true;
        }

        if (!isWhite && destXPosition == column && destYPosition == row + 1) {
            return true;
        }

        if (isWhite && row == 6 && destXPosition == column && destYPosition == row - 2) {
            return true;
        }

        if (!isWhite && row == 1 && destXPosition == column && destYPosition == row + 2) {
            return true;
        }

        return false;
    }

    public boolean pawnCanCapture(Box destinationBox) {
        int destXPosition = destinationBox.getXPosition(); 
        int destYPosition = destinationBox.getYPosition(); 

        if (isWhite && Math.abs(destXPosition - column) == 1 && destYPosition == row - 1) {
            return true;
        }

        if (!isWhite && Math.abs(destXPosition - column) == 1 && destYPosition == row + 1) {
            return true;
        }

        return false;
    }

    public boolean pawnCanMoveTwo(Box destinationBox) {

        if (isWhite && row == 6 && destinationBox.getXPosition() == column && destinationBox.getYPosition() == row - 2) {
            return true;
        }

        if (!isWhite && row == 1 && destinationBox.getXPosition() == column && destinationBox.getYPosition() == row + 2) {
            return true;
        }

        return false;
    }

    public void promotion(String newPieceType, chessBoard board) { 
        if ((isWhite && row == 0) || (!isWhite && row == 7)) {
            Piece newPiece = null;
            switch (newPieceType) {
                case "Queen":
                    newPiece = new Queen(board.getBox(column, row), player); 
                    break;
                case "Rook":
                    newPiece = new Rook(board.getBox(column, row), player); 
                    break;
              
            }

            if (newPiece != null) {
                board.replacePiece(this, newPiece);
            }
        }
    }
}
