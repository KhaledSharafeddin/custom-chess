package Piece;
<<<<<<< HEAD
//Piece.java
=======
//Pawn.java
import Game.Box;
>>>>>>> eb535ca5e8baaab170d97c182aa6c7b079d2d61e
import Game.Player;
import Game.Box;

<<<<<<< HEAD
public interface Piece {
    Player getPlayer();
    Box getBox();
    void setBox(Box destinationBox);
    boolean isValidMove(Box destinationBox);
    
=======
public class Pawn implements Piece {
    public String type;
    private Box box;
    private Player player;
    private boolean isWhite;
    private int column;
    private int row;

    public Pawn(Box box, Player player, boolean isWhite, int column, int row) {
        this.box = box;
        this.player = player;
        this.isWhite = isWhite;
        this.column = column;
        this.row = row;
    }


    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Box getBox() {
        return box;
    }

    @Override
    public void setBox(Box destinationBox) {
        this.box = destinationBox;
    }
   
    public Game.Type getType() {
    return Game.Type.PAWN;
    }
>>>>>>> eb535ca5e8baaab170d97c182aa6c7b079d2d61e



    // if you want to check if a piece is in an array -> implement this 
    
    // @Override
    // default int compareTo(Piece other) {
    //     return this.getType().compareTo(other.getType());
    //     return 0; // Placeholder, replace with actual comparison logic
    // }
}
