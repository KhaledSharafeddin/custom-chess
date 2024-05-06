package Piece;

public class Bishop implements Piece {

    private static Game.Type type;

    public Bishop(Game.Box game, Game.Player player){

    } 
    
    public static Game.Type getType(){
        return type;
    }

    public static boolean isValidMove(Game.Box destinationBox){
        //TODO: do the case 
        return false;
    }

}
