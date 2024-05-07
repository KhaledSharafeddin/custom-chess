package Piece;

import Game.Box;
import Game.Player;

public class Bishop implements Piece{
    private static Game.Type type;
    private Box box;
    private final Player player;
  
   

    public Bishop(Game.Box box, Game.Player player){
        this.box = box;
        this.player = player;
    } 

    public Player getPlayer(){
        return player;

    };

    public Box getBox(){
        return box;
    }

    public void setBox(Box destinationBox){
        this.box = destinationBox;
    }


    public static Game.Type getType(){
        return type;
    }

    public boolean isValidMove(Game.Box destinationBox){
        //TODO: do the case 
        return false;
    }

}
