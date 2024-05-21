package Game;

import GUI.GUI;
import Piece.Piece;

//standartGame.java
public class standardGame {
    static public Player player1;
    static public Player player2;

    public void game() {
        player1 = new Player(Color.WHITE, true);
        player2 = new Player(Color.BLACK, false);

    }

    public static Player getOpponent(Color color){

        if(color == color.BLACK){
            return player1;
        }
        else{
            return player2;
        }

    }

    // public static void addToOpponentCaptureList(Piece piece){
    //     if (piece.getColor()==Color.BLACK){
    //         player1.addToList(piece);
    //     }
    //     else{
    //         player2.addToList(piece);
    //     }
    // }


    public static void main(String[] args) {
        GUI.startGame();
    }
}