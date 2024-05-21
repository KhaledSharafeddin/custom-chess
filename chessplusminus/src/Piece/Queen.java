package Piece;

//Queen.java
import Game.Box;
import Game.Player;
import Game.standardGame;
import Game.Color;
import Game.Type;
import GUI.ChessBoardGui;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Queen implements Piece {
    private Box box;
    private Player player;
    private Color color;
    private BufferedImage image;

    public Queen(Box box, Color color) {
        this.box = box;
        this.color = color;
        loadImage();
    }

    private void loadImage() {
        String imageName = (color == Color.WHITE) ? "queen_white.png" : "queen_black.png";
        try {
            System.out.println("Attempting to load image: /pieces/" + imageName); // Debug output

            // Debug: check if the resource exists and print the full path
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

    public Game.Type getType() {
        return Type.QUEEN;
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
        int destX = destinationBox.getXPosition();
        int destY = destinationBox.getYPosition();
        int currX = box.getXPosition();
        int currY = box.getYPosition();

        if (destX == currX || destY == currY) {
            return true;
        }

        int dx = Math.abs(destX - currX);
        int dy = Math.abs(destY - currY);
        return dx == dy;
    }
}