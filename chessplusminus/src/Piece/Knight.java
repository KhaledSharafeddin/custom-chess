package Piece;

import java.awt.image.BufferedImage;

import Game.Box;
import Game.Player;
import GUI.ChessBoardGui;

public class Knight implements Piece {
    private Game.Type type;
    private Box box;
    private Player player;

    public Knight(Game.Box box, Game.Player player) {
        this.box = box;
        this.player = player;
        this.type = Game.Type.KNIGHT;
        //this.isWhite = isWhite;
        //see sprite in Pieces, 3 is the pos of Knight in the png.
        //if it is white, it takes 1st row, else, 2nd row (black)
        //isWhite to be implemented?
        this.sprite = sheet.getSubimage(3*sheetScale,isWhite ? 0 : sheetScale, sheetScale).getScaledInstance(ChessBoardGui.squareSize, sheetScale, BufferedImage.SCALE_SMOOTH);
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
        return type;
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
