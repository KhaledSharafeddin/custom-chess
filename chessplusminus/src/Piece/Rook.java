package Piece;

//Rook.java
import Game.Box;
import Game.Player;
import Game.Color;
import Game.standardGame;
import Game.Type;
import GUI.ChessBoardGui;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Rook implements Piece {
    private Box box;
    private Player player;
    private Color color;
    private BufferedImage image;

    public Rook(Box box, Color color) {
        this.box = box;
        this.color = color;
        loadImage();
    }

    private void loadImage() {
        String imageName = (color == Color.WHITE) ? "rook_white.png" : "rook_black.png";
        try {
            System.out.println("Attempting to load image: pieces/" + imageName); // Debug output
            URL resourceUrl = getClass().getResource("pieces/" + imageName);
            if (resourceUrl == null) {
                System.out.println("Image not found at path: pieces/" + imageName);
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
    public Game.Type getType() {
        return Game.Type.ROOK;
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
            if (hasClearPath(destinationBox)) {
                Piece destinationPiece = ChessBoardGui.getInstance().getPiece(destinationBox.getYPosition(),
                        destinationBox.getXPosition());
                return destinationPiece == null || destinationPiece.getColor() != this.color;
            }
        }
        return false;
    }

    private boolean hasClearPath(Box destinationBox) {
        int startX = box.getXPosition();
        int startY = box.getYPosition();
        int endX = destinationBox.getXPosition();
        int endY = destinationBox.getYPosition();

        int deltaX = (endX > startX) ? 1 : -1;
        int deltaY = (endY > startY) ? 1 : -1;

        for (int step = 1; step < Math.abs(endX - startX); step++) {
            int checkX = startX + step * deltaX;
            int checkY = startY + step * deltaY;
            if (ChessBoardGui.getInstance().getPiece(checkY, checkX) != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Color getColor() {
        return color;
    }

}