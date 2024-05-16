package Piece;
//Piece.java
import Game.Player;
import Game.Box;
import Game.Color;
import java.awt.Graphics2D;

public interface Piece {
    Player getPlayer();
    Box getBox();
    void setBox(Box destinationBox);
    boolean isValidMove(Box destinationBox);
    Color getColor();
    Game.Type getType();
    void paint(Graphics2D g2d);


    // if you want to check if a piece is in an array -> implement this 
    
    // @Override
    // default int compareTo(Piece other) {
    //     return this.getType().compareTo(other.getType());
    //     return 0; // Placeholder, replace with actual comparison logic
    // }
}
