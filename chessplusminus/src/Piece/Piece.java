package Piece;

import Game.Player;
import Game.Box;
import GUI.ChessBoardGui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public interface Piece {
    Player getPlayer();
    Box getBox();
    void setBox(Box destinationBox);
    boolean isValidMove(Box destinationBox);

    BufferedImage sheet = loadSheet();

    static BufferedImage loadSheet() {
        try {
            return ImageIO.read(ClassLoader.getSystemResourceAsStream("Pieces.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    default void paint(Graphics g2d) {
        g2d.drawImage(getSprite(), getXPos(), getYPos(), null);
    }

    int getXPos();
    int getYPos();
    Image getSprite();
}
