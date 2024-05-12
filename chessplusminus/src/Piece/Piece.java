package Piece;
//Piece.java
import Game.Player;
import Game.Box;

public interface Piece {
    Player getPlayer();
    Box getBox();
    void setBox(Box destinationBox);
<<<<<<< HEAD
    boolean isValidMove(Box destinationBox);
=======
    static boolean isValidMove(Box destinationBox){
        return true;
    };
>>>>>>> eb535ca5e8baaab170d97c182aa6c7b079d2d61e
    



    // if you want to check if a piece is in an array -> implement this 
    
    // @Override
    // default int compareTo(Piece other) {
    //     return this.getType().compareTo(other.getType());
    //     return 0; // Placeholder, replace with actual comparison logic
    // }
}
