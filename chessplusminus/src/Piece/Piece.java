package Piece;

import Game.Player;
import Game.Box;

public interface Piece {
    Player getPlayer();
    Box getBox();
    void setBox(Box destinationBox);
    boolean isValidMove(Box destinationBox);
}
