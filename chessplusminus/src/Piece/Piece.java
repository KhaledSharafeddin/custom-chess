package Piece;

import Game.Player;
import Game.Box;

public interface Piece {
    public static final Box box = new Box();
    public static final Player player = new Player();
    Player getPlayer();
    Box getBox();
    void setBox(Box destinationBox);
    boolean isValidMove(Box destinationBox);
}
