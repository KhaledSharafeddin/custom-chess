package Game;
//Box.java
import Piece.Piece;

public class Box {
     
<<<<<<< HEAD
    public int xPosition;
    public int yPosition;
    public Piece piece;
=======
    public static int xPosition;
    public static int yPosition;
    public static Piece piece;
>>>>>>> eb535ca5e8baaab170d97c182aa6c7b079d2d61e

    public Box(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    public Piece getPiece() {
<<<<<<< HEAD
        return this.piece;
    }
    public int[] getBox() {
        return new int[] {xPosition,yPosition};
    }
    
    public int getXPosition() {
        return this.xPosition;
=======
        return piece;
    }
    public static int[] getBox() {
        return new int[] {xPosition,yPosition};
    }
    
    public static int getXPosition() {
        return xPosition;
>>>>>>> eb535ca5e8baaab170d97c182aa6c7b079d2d61e
    }

    public static int getYPosition() {
        return yPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    
}
