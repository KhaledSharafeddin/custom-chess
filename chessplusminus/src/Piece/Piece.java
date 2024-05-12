package Piece;
//Piece.java
import Game.Player;
import Game.Box;

public interface Piece {
    Player getPlayer();
    Box getBox();
    void setBox(Box destinationBox);
    static boolean isValidMove(Box destinationBox){
        return true;
    };
    



    // if you want to check if a piece is in an array -> implement this 
    
    // @Override
    // default int compareTo(Piece other) {
    //     return this.getType().compareTo(other.getType());
    //     return 0; // Placeholder, replace with actual comparison logic
    // }
}
