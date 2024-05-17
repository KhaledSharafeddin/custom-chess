package Piece;

import GUI.ChessBoardGui;
//Pawn.java
import Game.Box;
import Game.Player;
import Game.Color;
//import Game.chessBoard;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Pawn implements Piece {
    public String type;
    private Box box;
    private Player player;
    private boolean isWhite;
    private BufferedImage image;
    private Color color;
    private boolean firstMove = true; // tracks whether pawn's first move

    public Pawn(Box box, Color color) {
        this.box = box;
        this.player = player;
        this.color = color;
        loadImage();
    }

    private void loadImage() {
        String imageName = (color == Color.WHITE) ? "pawn_white.png" : "pawn_black.png";
        try {
            System.out.println("Attempting to load image: /pieces/" + imageName); // Debug output

            // Debug: check if the resource exists and print the full path
            URL resourceUrl = getClass().getResource("/pieces/" + imageName);
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
        return player;
    }

    @Override
    public Box getBox() {
        return box;
    }

    @Override
    public void setBox(Box destinationBox) {
        this.box = destinationBox;
        firstMove = false; // pawn cannot move 2 steps after first move
    }

    public Game.Type getType() {
        return Game.Type.PAWN;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void paint(Graphics2D g2d) {
        // Implement painting logic for the piece
        if (image != null) {
            int x = box.getXPosition() * ChessBoardGui.TILE_SIZE;
            int y = box.getYPosition() * ChessBoardGui.TILE_SIZE;
            g2d.drawImage(image, x, y, ChessBoardGui.TILE_SIZE, ChessBoardGui.TILE_SIZE, null);
        }
    }

    @Override
    public boolean isValidMove(Box destinationBox) {
        int deltaRow = destinationBox.getYPosition() - box.getYPosition();
        int deltaCol = Math.abs(destinationBox.getXPosition() - box.getXPosition());

        ChessBoardGui board = ChessBoardGui.getInstance(); // Get the board instance

        if (color == Color.WHITE) {
            if (deltaCol == 0) {
                if (deltaRow == -1 && board.getPiece(box.getYPosition() - 1, box.getXPosition()) == null)
                    return true; // Move one square forward
                if (deltaRow == -2 && firstMove && board.getPiece(box.getYPosition() - 1, box.getXPosition()) == null
                        && board.getPiece(box.getYPosition() - 2, box.getXPosition()) == null)
                    return true; // Move two squares forward on first move
            } else if (deltaCol == 1 && deltaRow == -1) {
                // Capture diagonally
                Piece targetPiece = board.getPiece(box.getYPosition() - 1,
                        box.getXPosition() + (destinationBox.getXPosition() - box.getXPosition()));
                return targetPiece != null && targetPiece.getColor() != color;
            }
        } else {
            if (deltaCol == 0) {
                if (deltaRow == 1 && board.getPiece(box.getYPosition() + 1, box.getXPosition()) == null)
                    return true; // Move one square forward
                if (deltaRow == 2 && firstMove && board.getPiece(box.getYPosition() + 1, box.getXPosition()) == null
                        && board.getPiece(box.getYPosition() + 2, box.getXPosition()) == null)
                    return true; // Move two squares forward on first move
            } else if (deltaCol == 1 && deltaRow == 1) {
                // Capture diagonally
                Piece targetPiece = board.getPiece(box.getYPosition() + 1,
                        box.getXPosition() + (destinationBox.getXPosition() - box.getXPosition()));
                return targetPiece != null && targetPiece.getColor() != color;
            }
        }
        return false;
    }

    public boolean pawnCanCapture(Box destinationBox) {
        int destXPosition = destinationBox.getXPosition();
        int destYPosition = destinationBox.getYPosition();

        if (isWhite && Math.abs(destXPosition - box.xPosition) == 1 && destYPosition == box.yPosition - 1) {
            return true;
        }

        if (!isWhite && Math.abs(destXPosition - box.xPosition) == 1 && destYPosition == box.yPosition + 1) {
            return true;
        }

        return false;
    }

    public boolean pawnCanMoveTwo(Box destinationBox) {

        if (isWhite && box.yPosition == 6 && destinationBox.getXPosition() == box.xPosition
                && destinationBox.getYPosition() == box.yPosition - 2) {
            return true;
        }

        if (!isWhite && box.yPosition == 1 && destinationBox.getXPosition() == box.xPosition
                && destinationBox.getYPosition() == box.yPosition + 2) {
            return true;
        }

        return false;
    }

    public void promotion(String newPieceType, ChessBoardGui board) {
        if ((isWhite && box.yPosition == 0) || (!isWhite && box.yPosition == 7)) {
            Piece newPiece = null;
            switch (newPieceType) {
                case "Queen":
                    newPiece = new Queen(box, color);
                    break;
                case "Rook":
                    newPiece = new Rook(box, color);
                    break;

            }

            if (newPiece != null) {
                board.replacePiece(this, newPiece);
            }
        }
    }
}
