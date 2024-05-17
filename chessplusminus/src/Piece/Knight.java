package Piece;
//Knight.java
import java.awt.image.BufferedImage;

import Game.Box;
import Game.Color;
import Game.Player;
import GUI.ChessBoardGui;
import java.awt.Graphics2D;

public class Knight implements Piece {
    private static Game.Type type;
    private static Box box;
    private Player player;
    private Color color;
  

    public Knight( Box box, Color color){
       // this.player = player;
        this.box = box;
        this.color = color;
    } 

    /*
     * public Knight(ChessBoardGui board, int col, int row, boolean isWhite) {
     * super(board)
     * this.col = col;
     * this.row = row;
     * this.xPos = col * board.squareSize;
     * this.yPos = row * board.squareSize;
     * this.isWhite = isWhite;
     * this.name = "Knight"
     * this.sprite = sheet.getSubImage(3*sheetScale, isWHite ? 0 : sheetScale, sheetScale, sheetScale).getSelectedInstance(board.squareSize, board.squareSize, BufferedImage.SCALE_SMOOTH);
     * }
     */
    
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
        return type;
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
    public boolean isValidMove(Game.Box destinationBox) {
        int destX = destinationBox.getXPosition();
        int destY = destinationBox.getYPosition();

        int currentX = box.getXPosition();
        int currentY = box.getYPosition();

        int deltaX = Math.abs(destX - currentX);
        int deltaY = Math.abs(destY - currentY);

        return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
    }

}
