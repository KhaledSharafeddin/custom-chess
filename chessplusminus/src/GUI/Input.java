package GUI;

import java.awt.event.*;
import Game.Box;
import Game.Color;
import Game.Move;
import Piece.Piece;

public class Input implements MouseListener, MouseMotionListener {

    private ChessBoardGui chessBoardGui;
    private int clickedRow;
    private int clickedCol;

    public Input(ChessBoardGui chessBoardGui) {
        this.chessBoardGui = chessBoardGui;
    }
    private boolean isCurrentPlayerTurn(Piece piece) {
        if (piece == null) {
            return false; // Not the current player's turn if no piece is clicked
        }
        return chessBoardGui.isWhiteTurn && piece.getColor() == Color.WHITE  ||
               !chessBoardGui.isWhiteTurn && piece.getColor() == Color.BLACK;
          
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickedRow = e.getY() / ChessBoardGui.TILE_SIZE;
        clickedCol = e.getX() / ChessBoardGui.TILE_SIZE;

        if (isCurrentPlayerTurn(chessBoardGui.selectedPiece)) {
            // Check if a piece is already selected
            if (chessBoardGui.selectedPiece != null) {
                // Try to move the selected piece to the clicked location
                Box destinationBox = new Box(clickedCol, clickedRow);
                if (chessBoardGui.isValidMove(new Move(chessBoardGui, chessBoardGui.selectedPiece, clickedCol, clickedRow))) {
                    chessBoardGui.selectedPiece.setBox(destinationBox);
                    chessBoardGui.selectedPiece = null; // Deselect the piece after moving
                } else {
                    // Deselect the piece if the move is not valid
                    chessBoardGui.selectedPiece = null;
                }
            } else {
                // Select a piece at the clicked location
                Piece piece = chessBoardGui.getPiece(clickedRow, clickedCol);
                if (piece != null) {
                    chessBoardGui.selectedPiece = piece;
                }
            }

            chessBoardGui.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed");
        clickedRow = e.getY() / ChessBoardGui.TILE_SIZE;
        clickedCol = e.getX() / ChessBoardGui.TILE_SIZE;

        // Select a piece at the clicked location
        Piece piece = chessBoardGui.getPiece(clickedRow, clickedCol);
        if (piece != null) {
            chessBoardGui.selectedPiece = piece;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isCurrentPlayerTurn(chessBoardGui.selectedPiece)) {
            if (chessBoardGui.selectedPiece != null) {
                int row = e.getY() / ChessBoardGui.TILE_SIZE;
                int col = e.getX() / ChessBoardGui.TILE_SIZE;
                Box destinationBox = new Box(col, row);
                if (chessBoardGui.isValidMove(new Move(chessBoardGui, chessBoardGui.selectedPiece, col, row))) {
                    chessBoardGui.selectedPiece.setBox(destinationBox);
                    chessBoardGui.selectedPiece = null; // Deselect the piece after moving
                }
            }
        chessBoardGui.repaint();
    }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Optional: Visual effect when mouse enters the board
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Optional: Visual effect when mouse exits the board
    }

    public void mouseDragged(MouseEvent e) {
        // Implement dragging functionality
        if (isCurrentPlayerTurn(chessBoardGui.selectedPiece)) {
            if (chessBoardGui.selectedPiece != null) {
                int row = e.getY() / ChessBoardGui.TILE_SIZE;
                int col = e.getX() / ChessBoardGui.TILE_SIZE;
                if (chessBoardGui.inChessBoard(row, col)) {
                    chessBoardGui.selectedPiece.setBox(new Box(col, row));
                    chessBoardGui.repaint();
                }
            }
        }
    }

    // Implement the required method from MouseMotionListener
    @Override
    public void mouseMoved(MouseEvent e) {
        int row = e.getY() / ChessBoardGui.TILE_SIZE;
        int col = e.getX() / ChessBoardGui.TILE_SIZE;

        // Optional: Implement visual effects based on mouse position (e.g., highlight
        // potential moves)
        // You can use this method to highlight squares where the selected piece could
        // potentially move
        // if validMoves is not null (meaning a piece is selected).
        if (chessBoardGui.selectedPiece != null) {
            // Code to highlight valid moves visually (optional)
        }
    }
}