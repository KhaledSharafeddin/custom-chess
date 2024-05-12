package Piece;

import Game.Box;
import Game.Player;

public class Rook implements Piece{
    private static Game.Type type;
    private Box box;
    private Player player;
  

    public Rook(Game.Box box, Game.Player player){
        this.box = box;
        this.player = player;
    } 
        /*
     * public Knight(ChessBoardGui board, int col, int row, boolean isWhite) {
     * super(board)
     * this.col = col;
     * this.row = row;
     * this.xPos = col * board.squareSize;
     * this.yPos = board.squareSize;
     * this.isWhite = isWhite;
     * this.name = "Rook"
     * this.sprite = sheet.getSubImage(4*sheetScale, isWHite ? 0 : sheetScale, sheetScale, sheetScale).getSelectedInstance(board.squareSize, board.squareSize, BufferedImage.SCALE_SMOOTH);
     * }
     */

    @Override
    public Player getPlayer(){
        return player;

    };
    @Override
    public Box getBox(){
        return box;
    }

    @Override
    public void setBox(Box destinationBox){
        this.box = destinationBox;
    }


    public static Game.Type getType(){
        return type;
    }

    @Override
public boolean isValidMove(Box destinationBox) {
    int destX = destinationBox.getXPosition();
    int destY = destinationBox.getYPosition();

    int currentX = box.getXPosition();
    int currentY = box.getYPosition();

    return destX == currentX || destY == currentY;
}


}
