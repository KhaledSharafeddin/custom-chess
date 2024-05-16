    package Game;
    //Player.java
import java.util.*;

import GUI.ChessBoardGui;
import Piece.Piece;

    public class Player {
        public static Color playerColor;
        public boolean goesFirst;
        public boolean isLoser;
        public boolean isTurn;
        public int score;
        public static List<Piece> capturedPieces = new ArrayList<>();
 //this changed from Array -> Vector 

        //is captured pieces (enemy's?)



        // public Player(){

        // }
        
        public Player(Color playerColor, boolean goesFirst) {
            this.playerColor = playerColor;
            this.goesFirst = goesFirst;
        }
        
        //i am not sure if we need both -> as it depends on the color 
        public Vector<Piece> getAllyPieces(Color playerColor) {
            Vector<Piece> allies = new Vector<>();
            for (Piece piece : ChessBoardGui.getPieceList()) {
                if (piece.getColor() == playerColor) {
                    allies.add(piece);
                }
            }
            return allies;
        }

        public Vector<Piece> getEnemyPieces(Color playerColor) {
            Vector<Piece> enemies = new Vector<>();
            for (Piece piece : ChessBoardGui.getPieceList()) {
                if (piece.getColor() != playerColor) {
                    enemies.add(piece);
                }
            }
            return enemies;
        }
        public int getScore() {
            return this.score;
        }

        public Color getColor() {
            return this.playerColor;
        }

        public static boolean isWhite() {
            return playerColor == Color.WHITE;
        }

        //we could do it when we starting the game as a condition 
        public static boolean startFirst() {
            return Player.isWhite();
        }
    }
