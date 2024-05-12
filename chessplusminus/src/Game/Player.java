package Game;
//Player.java
import java.util.ArrayList;
import java.util.*;
import java.util.Vector;
import Piece.Piece;

public class Player {
    public static Color playerColor;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> eb535ca5e8baaab170d97c182aa6c7b079d2d61e
    public boolean goesFirst;
=======
    public static boolean goesFirst;
>>>>>>> f6fb83a (Co-authored-by: Emir Mut <emirmut1903@users.noreply.github.com>)
    public boolean isLoser;
    public boolean isTurn;
    public int score;
    public static List<Piece> capturedPieces; //this changed from Array -> Vector 

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

    public static boolean isWhite() {
        if (playerColor == Color.WHITE) {
            return true;
        }
        return false;
    }

    //we could do it when we starting the game as a condition 
    public static boolean startFirst(){
        if (Player.isWhite() == true){
            return true;
        }
        return false;
    }
}
