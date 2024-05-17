package Piece;
//Queen.java
import Game.Box;
import Game.Player;
import Game.Color;
import java.awt.Graphics2D;

public class Queen implements Piece {
    private Game.Type type;
    private static Box box;
    private Player player;
    private Color color;

    public Queen(Box box, Color color) {
        this.box = box;
        //this.player = player;
        this.type = Game.Type.QUEEN;
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
    }

    public Game.Type getType() {
        return type;
    }
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void paint(Graphics2D g2d) {
        // Implement painting logic for the piece
    }

    @Override
    public  boolean isValidMove(Box destinationBox) {
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