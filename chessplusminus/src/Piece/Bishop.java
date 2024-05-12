package Piece;
//Bishop.java
import Game.Box;
import Game.Player;

public class Bishop implements Piece {
    private Game.Type type;
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
    public boolean isValidMove(Game.Box destinationBox) {
        int destX = destinationBox.getXPosition();
        int destY = destinationBox.getYPosition();
        int currentX = this.box.getXPosition();
        int currentY = this.box.getYPosition();
        int deltaX = Math.abs(destX - currentX);
        int deltaY = Math.abs(destY - currentY);

        return deltaX == deltaY;
    }
}
