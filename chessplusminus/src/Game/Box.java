package Game;
//Box.java
import Piece.Piece;

public class Box {
     
    public static int xPosition;
    public static int yPosition;
    public static Piece piece;

    public Box(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    public Piece getPiece() {
        return piece;
    }
    public static int[] getBox() {
        return new int[] {xPosition,yPosition};
    }
    
    public static int getXPosition() {
        return xPosition;
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
