package Piece;

import Game.Box;
import Game.Player;

public class Rook implements Piece{
    private static Game.Type type;
    private Box box;
    private Player player;
  

    public Rook(Game.Box box, Game.Player player){
        this.box = box;
        this.player = player;
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


}
