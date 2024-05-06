package Piece;

public class Queen implements Piece{
    private static Game.Type type;


    public Queen(Game.Box game, Game.Player player){

    } 

    public static Game.Type getType(){
        return type;
    }

    public boolean isValidMove(Game.Box destinationBox){
        //TODO: do the case 
        return false;
    }

}
