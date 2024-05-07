package Piece;

import Game.Box;
import Game.Player;

public class Knight implements Piece {
    private static Game.Type type;
    private Box box;
    private Player player;

    public Knight(Game.Box box, Game.Player player){
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
    public boolean isValidMove(Game.Box destinationBox) {
        if (Math.abs(box.getXPosition() - destinationBox.getXPosition()) == 2 && Math.abs(box.getYPosition() - destinationBox.getYPosition()) == 1)
			return true;
		if (Math.abs(box.getXPosition() - destinationBox.getXPosition()) == 1 && Math.abs(box.getYPosition() - destinationBox.getYPosition()) == 2)
			return true;
		return false;
    }

}
