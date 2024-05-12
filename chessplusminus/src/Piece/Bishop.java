package Piece;
//Bishop.java
import Game.Box;
import Game.Player;
import Game.chessBoard;

public class Bishop implements Piece {
    private Game.Type type;
    private static Box box;
    private Player player;

    public Bishop(Game.Box box, Game.Player player) {
        this.box = box;
        this.player = player;
        this.type = Game.Type.BISHOP;
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
        return type;
    }

    @Override
    public  static boolean isValidMove(Game.Box destinationBox) {
        int destX = destinationBox.getXPosition();
        int destY = destinationBox.getYPosition();

        int currentX = box.getXPosition();
        int currentY = box.getYPosition();

        int deltaX = Math.abs(destX - currentX);
        int deltaY = Math.abs(destY - currentY);

        return deltaX == deltaY;
    }

    public boolean moveCollidesWithPieces(int targetX, int targetY) {
        // Up left
        if (Game.Box.getXPosition() > targetX && Game.Box.getYPosition() > targetY) {
            for (int i = 1; i < Math.abs(Game.Box.getXPosition() - targetX); i++) {
                if (chessBoard.getPiece(Box(Game.Box.getXPosition() - i, Game.Box.getYPosition() - i)) != null) {
                    return true;
                }
            }
        }
        // Up right
        if (Game.Box.getXPosition() < targetX && Game.Box.getYPosition() > targetY) {
            for (int i = 1; i < Math.abs(Game.Box.getXPosition() - targetX); i++) {
                if (chessBoard.getPiece(Game.Box.getXPosition() + i, Game.Box.getYPosition() - i) != null) {
                    return true;
                }
            }
        }
        // Down left
        if (Game.Box.getXPosition() > targetX && Game.Box.getYPosition() < targetY) {
            for (int i = 1; i < Math.abs(Game.Box.getXPosition() - targetX); i++) {
                if (board.getPiece(Game.Box.getXPosition() - i, Game.Box.getYPosition() + i) != null) {
                    return true;
                }
            }
        }
        // Down right
        if (Game.Box.getXPosition() < targetX && Game.Box.getYPosition() < targetY) {
            for (int i = 1; i < Math.abs(Game.Box.getXPosition() - targetX); i++) {
                if (board.getPiece(Game.Box.getXPosition() + i, Game.Box.getYPosition() + i) != null) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
     