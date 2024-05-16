package Piece;
import GUI.ChessBoardGui;
//Pawn.java
import Game.Box;
import Game.Player;
import Game.Color;
//import Game.chessBoard;

public class Pawn implements Piece {
    public String type;
    private Box box;
    private Player player;
    private boolean isWhite;
   
    private Color color;
    private boolean firstMove; //tracks whether pawn's first move 

    public Pawn(Box box, Color color) {
        this.box = box;
        this.player = player;
        //this.isWhite = isWhite;
        this.color = color;
      
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
        firstMove = false; //pawn cannot move 2 steps after first move 
    }
   
    public Game.Type getType() {
    return Game.Type.PAWN;
    }

    @Override
    public Color getColor() {
        return color;
    }


    @Override
   public boolean isValidMove(Box destinationPosition) {
        int deltaRow = Math.abs(destinationPosition.getYPosition() - getBox().getYPosition());
        int deltaCol = Math.abs(destinationPosition.getXPosition() - getBox().getYPosition());

        // Standard one or two squares move forward (depending on first move)
        if (color == Color.WHITE) {
            if (deltaRow == 1 && deltaCol == 0 && getBox().getPiece() == null) {
                return true;
            } else if (deltaRow == 2 && deltaCol == 0 && firstMove && getBox().getPiece() == null && 
                       getBox().getYPosition() == 6 && getBox().getPieceAt(1) == null) {
                return true;
            }
        } else { // Black pawn moves down the board
            if (deltaRow == 1 && deltaCol == 0 && getBox().getPiece() == null) {
                return true;
            } else if (deltaRow == 2 && deltaCol == 0 && firstMove && getBox().getYPosition() == 1 && 
                       getBox().getPiece() == null && getBox().getPieceAt(-1) == null) {
                return true;
            }
        }

        // Capturing diagonally
        if (deltaRow == 1 && deltaCol == 1 && getBox().getPieceAt(1, 1) != null && 
                getBox().getPieceAt(1, 1).getColor() != color) {
            return true;
        } else if (deltaRow == 1 && deltaCol == 1 && getBox().getPieceAt(-1, 1) != null && 
                   getBox().getPieceAt(-1, 1).getColor() != color) {
            return true;
        }

        return false;
    }


    public boolean pawnCanCapture(Box destinationBox) {
        int destXPosition = destinationBox.getXPosition(); 
        int destYPosition = destinationBox.getYPosition(); 

        if (isWhite && Math.abs(destXPosition - box.xPosition) == 1 && destYPosition == box.yPosition - 1) {
            return true;
        }

        if (!isWhite && Math.abs(destXPosition - box.xPosition) == 1 && destYPosition == box.yPosition + 1) {
            return true;
        }

        return false;
    }

    public boolean pawnCanMoveTwo(Box destinationBox) {

        if (isWhite && box.yPosition == 6 && destinationBox.getXPosition() == box.xPosition && destinationBox.getYPosition() == box.yPosition - 2) {
            return true;
        }

        if (!isWhite && box.yPosition == 1 && destinationBox.getXPosition() == box.xPosition && destinationBox.getYPosition() == box.yPosition + 2) {
            return true;
        }

        return false;
    }

    public void promotion(String newPieceType, ChessBoardGui board) { 
        if ((isWhite && box.yPosition == 0) || (!isWhite && box.yPosition == 7)) {
            Piece newPiece = null;
            switch (newPieceType) {
                case "Queen":
                    newPiece = new Queen(box, color); 
                    break;
                case "Rook":
                    newPiece = new Rook (box, color); 
                    break;
              
            }

            if (newPiece != null) {
                board.replacePiece(this, newPiece);
            }
        }
    }
}
