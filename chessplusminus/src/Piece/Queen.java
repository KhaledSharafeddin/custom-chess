package Piece;

import Game.Box;
import Game.Player;

public class Queen implements Piece{
    private static Game.Type type;
    private Box box;
    private Player player;
  

    public Queen(Game.Box box, Game.Player player){
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
    public boolean isValidMove(Game.Box destinationBox){
        //TODO: do the case 
        return false;
    }

}
