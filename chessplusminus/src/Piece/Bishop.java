package Piece;
//Bishop.java
import Game.Box;
import Game.Player;
//import Game.chessBoard;
import Game.Color;
import Game.Type;
import GUI.ChessBoardGui;
import java.awt.Graphics2D;

public class Bishop implements Piece {
    private static Game.Type type;
    private static Box box;
    private Player player;
    private Color color;
  

    public Bishop( Box box, Color color){
       //this.player = player;
        this.box = box;
        this.color = color;
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

    @Override
    public Game.Type getType() {
        return Game.Type.BISHOP;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void paint(Graphics2D g2d) {
        // Implement painting logic for the piece
    }

    @Override
    public boolean isValidMove(Box destinationPosition) {
        int deltaRow = Math.abs(destinationPosition.getYPosition() - getBox().getYPosition());
        int deltaCol = Math.abs(destinationPosition.getYPosition()- getBox().getYPosition());

        // Bishops move diagonally as long as the path is clear
        return deltaRow == deltaCol && getBox().hasClearPath(destinationPosition);
    }

    // private boolean moveCollidesWithPieces(int currentX, int currentY, int targetX, int targetY) {
    //     int deltaX = targetX > currentX ? 1 : -1;
    //     int deltaY = targetY > currentY ? 1 : -1;
    //     int steps = Math.abs(targetX - currentX); // Since deltaX == deltaY, we can use either deltaX or deltaY

    //     // Check all squares along the path for collisions
    //     for (int i = 1; i < steps; i++) {
    //         int checkX = currentX + i * deltaX;
    //         int checkY = currentY + i * deltaY;
    //         if (board.getPiece(new Box(checkX, checkY)) != null) {  // Assume board has a method getPiece that takes a Box
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}