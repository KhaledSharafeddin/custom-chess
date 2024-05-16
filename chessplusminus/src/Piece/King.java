package Piece;
//King.java
import Game.Box;
import Game.Color;
import Game.Player;

public class King implements Piece {
    private static Game.Type type;
    private static Box box;
    private Player player;
    private Color color;
  

    public King(Box box, Color color){
        //this.player = player;
        this.box = box;
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
