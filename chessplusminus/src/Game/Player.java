package Game;

import java.util.ArrayList;
import java.util.Vector;
import Piece.Piece;

public class Player {
    public Color playerColor;
    public boolean goesFirst;
    public boolean isLoser;
    public boolean isTurn;
    public int score;
    public Vector<Piece> capturedPieces; //this changed from Array -> Vector 

    //is captured pieces (enemy's?)



    // public Player(){

    // }

    public Player(Color playerColor, boolean goesFirst) {
        this.playerColor = playerColor;
        this.goesFirst = goesFirst;
    }

    //i am not sure if we need both -> as it depends on the color 
    public Vector getAllyPieces(Color playerColor) {
        //change THis 
        return capturedPieces;
    }

    public Vector getEnemyPieces(Color playerColor) {
       if (playerColor == Color.WHITE){
            
       }
        return capturedPieces;
        
    }

    public int getScore() {
        return this.score;
    }

    public Color getColor() {
        return this.playerColor;
    }

    public boolean isWhite() {
        if (playerColor == Color.WHITE) {
            goesFirst = true;
            return true;
        }
        goesFirst = false;
        return false;
    }
}
