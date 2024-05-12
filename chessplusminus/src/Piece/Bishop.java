package Piece;

import Game.Box;
import Game.Player;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Bishop implements Piece {
    private Game.Type type;
    private Box box;
    private Player player;

    public Bishop(Game.Box box, Game.Player player) {
        this.box = box;
        this.player = player;
        this.type = Game.Type.BISHOP;
        //see sprite in Pieces, 2 is the pos of bishop in the png.
        //if it is white, it takes 1st row, else, 2nd row (black)
        //isWhite to be implemented?
        if(Game.Player.playerColor == Color.white){
            this.sprite=sheet.getSubimage(2* sheetScale, isWhite? 0:sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);

        } else{
            this.sprite=sheet.getSubimage(2* sheetScale, isWhite? 1:sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);

        }
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

        return deltaX == deltaY;
    }
}
