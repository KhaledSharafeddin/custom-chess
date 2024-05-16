package Piece;
//Rook.java
import Game.Box;
import Game.Color;
import Game.Player;

public class Rook implements Piece{
    private static Game.Type type;
    private static Box box;
    private Player player;
    private Color color;
  

    public Rook(Box box, Color color){
        this.player = player;
        this.box = box;
        this.color = color;
    } 

    @Override
    public Player getPlayer(){
        return player;

    };
    @Override
    public Box getBox(){
        return box;
    }

    @Override
    public void setBox(Box destinationBox){
        this.box = destinationBox;
    }


    public static Game.Type getType(){
        return type;
    }

    @Override
    public boolean isValidMove(Box destinationBox) {
        int destX = destinationBox.getXPosition();
        int destY = destinationBox.getYPosition();

        int currentX = box.getXPosition();
        int currentY = box.getYPosition();

        return destX == currentX || destY == currentY;
}

    @Override
    public Color getColor() {
        return color;
    }


}
