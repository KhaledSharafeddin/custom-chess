package Piece;

import Game.*;
import Game.Player;
import Game.Color;
import Game.Type;
import GUI.ChessBoardGui;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Bishop implements Piece {
    private Box box;
    private Player player;
    private Color color;
    private BufferedImage image;

    public Bishop(Box box, Color color) {
        this.box = box;
        this.color = color;
        loadImage();
    }

    private void loadImage() {
        String imageName = (color == Color.WHITE) ? "bishop_white.png" : "bishop_black.png";
        try {
            System.out.println("Attempting to load image: /pieces/" + imageName); // Debug output
            URL resourceUrl = getClass().getResource("pieces/" + imageName);
            if (resourceUrl == null) {
                System.out.println("Image not found at path: /pieces/" + imageName);
            } else {
                System.out.println("Found image at path: " + resourceUrl);
                image = ImageIO.read(resourceUrl);
                System.out.println("Successfully loaded image: " + imageName);
            }
        } catch (IOException e) {
            System.out.println("Exception while loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Player getPlayer() {
        if(color == Color.BLACK){
            player = standardGame.player2;
            return player;
        }
        else{
            player = standardGame.player1;
            return player;
        }   
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
    public Type getType() {
        return Type.BISHOP;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void paint(Graphics2D g2d) {
        if (image != null) {
            int x = box.getXPosition() * ChessBoardGui.TILE_SIZE;
            int y = box.getYPosition() * ChessBoardGui.TILE_SIZE;
            g2d.drawImage(image, x, y, ChessBoardGui.TILE_SIZE, ChessBoardGui.TILE_SIZE, null);
        }
    }

    @Override
    public boolean isValidMove(Box destinationBox) {
        int deltaRow = Math.abs(destinationBox.getYPosition() - box.getYPosition());
        int deltaCol = Math.abs(destinationBox.getXPosition() - box.getXPosition());

        // Bishops move diagonally
        if (deltaRow == deltaCol) {
            // Implement the clear path check logic here
            return hasClearPath(destinationBox);
        }
        return false;
    }

    private boolean hasClearPath(Box destinationBox) {
        // Implement the actual path check logic to ensure no pieces are in the way
        int startY = Math.min(box.getYPosition(), destinationBox.getYPosition());
        int endY = Math.max(box.getYPosition(), destinationBox.getYPosition());
        int startX = Math.min(box.getXPosition(), destinationBox.getXPosition());
        int endX = Math.max(box.getXPosition(), destinationBox.getXPosition());

        int deltaX = (destinationBox.getXPosition() > box.getXPosition()) ? 1 : -1;
        int deltaY = (destinationBox.getYPosition() > box.getYPosition()) ? 1 : -1;

        for (int step = 1; step < Math.abs(endX - startX); step++) {
            int checkX = box.getXPosition() + step * deltaX;
            int checkY = box.getYPosition() + step * deltaY;
            if (ChessBoardGui.getInstance().getPiece(checkY, checkX) != null) {
                return false;
            }
        }
        return true;
    }
}
