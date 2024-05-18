package GUI;

import javax.swing.*;
//ChessBoardGui.java
import Game.Move;
import Game.Logic;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;
import Piece.Bishop;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import Game.Color;
import Game.Box;

import java.awt.*;
import java.util.ArrayList;

public class ChessBoardGui extends JPanel {

    public static final int TILE_SIZE = 85;
    ArrayList<Piece> pieceList = new ArrayList<>();
    int row = 8;
    int column = 8;
    private Piece[][] board;
    private static ChessBoardGui instance;
    public Piece selectedPiece;
    Input input = new Input(this);

    public ChessBoardGui() {
        instance = this;
        this.setPreferredSize(new Dimension(column * TILE_SIZE, row * TILE_SIZE));
        this.setBackground(java.awt.Color.green);
        addPieces();

        this.addMouseListener(new Input(this));
        this.addMouseMotionListener(new Input(this));
    }

    public static ChessBoardGui getInstance() {
        return instance;
    }

    public void addPiece() {

        addPieces();

        this.addMouseListener(input);
        this.addMouseMotionListener(input);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void addPieces() {

        // Black pieces
        pieceList.add(new Rook(new Box(0, 0), Color.BLACK));
        pieceList.add(new Knight(new Box(1, 0), Color.BLACK));
        pieceList.add(new Bishop(new Box(2, 0), Color.BLACK));
        pieceList.add(new King(new Box(3, 0), Color.BLACK));
        pieceList.add(new Queen(new Box(4, 0), Color.BLACK));
        pieceList.add(new Bishop(new Box(5, 0), Color.BLACK));
        pieceList.add(new Knight(new Box(6, 0), Color.BLACK));
        pieceList.add(new Rook(new Box(7, 0), Color.BLACK));

        for (int col = 0; col < 8; col++) {
            pieceList.add(new Pawn(new Box(col, 1), Color.BLACK)); // Black pawns on rank 1
        }

        // White pieces
        pieceList.add(new Rook(new Box(0, 7), Color.WHITE));
        pieceList.add(new Knight(new Box(1, 7), Color.WHITE));
        pieceList.add(new Bishop(new Box(2, 7), Color.WHITE));
        pieceList.add(new King(new Box(4, 7), Color.WHITE));
        pieceList.add(new Queen(new Box(3, 7), Color.WHITE));
        pieceList.add(new Bishop(new Box(5, 7), Color.WHITE));
        pieceList.add(new Knight(new Box(6, 7), Color.WHITE));
        pieceList.add(new Rook(new Box(7, 7), Color.WHITE));

        for (int col = 0; col < 8; col++) {
            pieceList.add(new Pawn(new Box(col, 6), Color.WHITE)); // White pawns on rank 6
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Paint the board
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                g2d.setColor((c + r) % 2 == 0 ? new java.awt.Color(192, 192, 192) : new java.awt.Color(0, 217, 181));
                g2d.fillRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        // Paint the pieces
        for (Piece piece : pieceList) {
            piece.paint(g2d); // Ensure each piece implements paint method
        }

        // Paint the highlights
        if (selectedPiece != null) {
            for (Move move : getValidMoves(selectedPiece)) {
                int r = move.getNewRow();
                int c = move.getNewCol();
                g2d.setColor(new java.awt.Color(2, 255, 0, 107));
                g2d.fillRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    public boolean isValidMove(Move move) {
        return Logic.isMoveValid(this, move.getPiece(), move.getNewRow(), move.getNewCol());
    }

    public boolean inChessBoard(int row, int col) {
        return (row >= 0 && row < this.row) && (col >= 0 && col < this.column);
    }

    public ArrayList<Move> getValidMoves(Piece selectedPiece) {
        ArrayList<Move> validMoves = new ArrayList<>();
        for (int row = 0; row < this.row; row++) {
            for (int col = 0; col < this.column; col++) {
                Move potentialMove = new Move(this, selectedPiece, row, col);
                if (isValidMove(potentialMove)) {
                    validMoves.add(potentialMove);
                }
            }
        }
        return validMoves;
    }

    public Piece getPiece(int row, int col) {
        for (Piece piece : pieceList) {
            if ((piece.getBox()).getYPosition() == row && (piece.getBox()).getXPosition() == col) {
                return piece;
            }
        }
        return null; // No piece found at that position
    }

    public Piece getBox(int row, int col) {
        if (isValidSquare(row, col)) { // Check for valid square coordinates
            return board[row][col];
        } else {
            return null; // Return null if coordinates are outside the board
        }
    }

    public void replacePiece(Piece oldPiece, Piece newPiece) {
        if (isValidSquare(oldPiece.getBox().yPosition, oldPiece.getBox().xPosition)) {
            board[oldPiece.getBox().yPosition][oldPiece.getBox().xPosition] = newPiece;
            repaint(); // Trigger a repaint to update the visual board
        } else {
            // Handle potential error (no selected square)
            System.out.println("No square selected for replacePiece");
        }
    }

    private boolean isValidSquare(int r, int c) {
        // Implement logic to check if (row, col) is within board boundaries
        return r >= 0 && r < row && c >= 0 && c < column;
    }

    public ArrayList<Piece> getPieceList() {
        return pieceList;
    }
}