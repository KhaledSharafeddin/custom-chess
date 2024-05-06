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
    public ArrayList<Piece> capturedPieces;

    public Player(Color playeColor, boolean goesFirst) {
        this.playerColor = playeColor;
        this.goesFirst = goesFirst;
    }

    public Vector getAllyPieces(Color playerColor) {
        
    }

    public Vector getEnemyPieces(Color playerColor) {
        
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
