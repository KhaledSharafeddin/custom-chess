package Game;
import GUI.ChessBoardGui;
//Box.java
import Piece.Piece;

public class Box {
     
    public int xPosition;
    public int yPosition;
    public Piece piece;

    public Box(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int[] getBox() {
        return new int[] {xPosition,yPosition};
    }
    
    public int getXPosition() {
        return this.xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public boolean hasClearPath(Box destinationPosition) {
        // Implement path checking logic
        return true; // Placeholder implementation
    }

    public Piece getPieceAt(int deltaX, int deltaY, ChessBoardGui board) {
        int targetX = this.xPosition + deltaX;
        int targetY = this.yPosition + deltaY;
        if (board.inChessBoard(targetY, targetX)) {
            return board.getPiece(targetY, targetX);
        }
        return null;
    }
    
}
