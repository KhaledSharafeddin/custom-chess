package Piece;
//Bishop.java
import Game.Box;
import Game.Player;
import Game.chessBoard;
import Game.Color;
import Game.Type;
import GUI.ChessBoardGui;

public class Bishop implements Piece {
    private Type type;
    private Box box;
    private Player player;
    private ChessBoardGui board;

    // Constructor to accept the ChessBoardGui instance, position coordinates, and color
    public Bishop(ChessBoardGui board, int x, int y, boolean isWhite) {
        this.board = board;
        this.box = new Box(x, y);  // Assuming there is a constructor in Box that accepts x, y coordinates
        this.player = new Player(isWhite ? Color.WHITE : Color.BLACK, isWhite);  // Assuming this is how Player is constructed
        this.type = Type.BISHOP;
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

    public Type getType() {
        return type;
    }

    @Override
    public boolean isValidMove(Box destinationBox) {
        int destX = destinationBox.getXPosition();
        int destY = destinationBox.getYPosition();
        int currentX = this.box.getXPosition();
        int currentY = this.box.getYPosition();
        int deltaX = Math.abs(destX - currentX);
        int deltaY = Math.abs(destY - currentY);

        if (deltaX == deltaY) {
            return !moveCollidesWithPieces(currentX, currentY, destX, destY);
        }
        return false;
    }

    private boolean moveCollidesWithPieces(int currentX, int currentY, int targetX, int targetY) {
        int deltaX = targetX > currentX ? 1 : -1;
        int deltaY = targetY > currentY ? 1 : -1;
        int steps = Math.abs(targetX - currentX); // Since deltaX == deltaY, we can use either deltaX or deltaY

        // Check all squares along the path for collisions
        for (int i = 1; i < steps; i++) {
            int checkX = currentX + i * deltaX;
            int checkY = currentY + i * deltaY;
            if (board.getPiece(new Box(checkX, checkY)) != null) {  // Assume board has a method getPiece that takes a Box
                return true;
            }
        }
        return false;
    }
}