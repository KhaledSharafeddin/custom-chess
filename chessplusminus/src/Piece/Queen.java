package Piece;

import Game.Box;
import Game.Player;

public class Queen implements Piece {
    private Game.Type type;
    private Box box;
    private Player player;

    public Queen(Box box, Player player) {
        this.box = box;
        this.player = player;
        this.type = Game.Type.QUEEN;
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
    public boolean isValidMove(Box destinationBox) {
        int destX = destinationBox.getXPosition();
        int destY = destinationBox.getYPosition();
        int currX = box.getXPosition();
        int currY = box.getYPosition();

        if (destX == currX || destY == currY) {
            return true;
        }

        int dx = Math.abs(destX - currX);
        int dy = Math.abs(destY - currY);
        return dx == dy;
    }
}
