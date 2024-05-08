package Piece;

import Game.Box;
import Game.Player;

public class King implements Piece {
    private Game.Type type;
    private Box box;
    private Player player;

    public King(Game.Box box, Game.Player player) {
        this.box = box;
        this.player = player;
        this.type = Game.Type.KING;
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
    public boolean isValidMove(Game.Box destinationBox) {
        int destX = destinationBox.getXPosition();
        int destY = destinationBox.getYPosition();

        int currentX = box.getXPosition();
        int currentY = box.getYPosition();

        int deltaX = Math.abs(destX - currentX);
        int deltaY = Math.abs(destY - currentY);

        return deltaX <= 1 && deltaY <= 1;
    }
}
