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
    }

        /*
     * public Bishop(ChessBoardGui board, int col, int row, boolean isWhite) {
     * super(board)
     * this.col = col;
     * this.row = row;
     * this.xPos = col * board.squareSize;
     * this.yPos = board.squareSize;
     * this.isWhite = isWhite;
     * this.name = "Bishop"
     * this.sprite = sheet.getSubImage(2*sheetScale, isWHite ? 0 : sheetScale, sheetScale, sheetScale).getSelectedInstance(board.squareSize, board.squareSize, BufferedImage.SCALE_SMOOTH);
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
