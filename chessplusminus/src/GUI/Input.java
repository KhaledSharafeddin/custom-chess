package GUI;

import Game.Box;
import Game.Logic;
import Game.Move;
import Piece.Piece;
import java.awt.event.*;

public class Input implements MouseListener, MouseMotionListener {

    private ChessBoardGui chessBoardGui;
    private int clickedRow;
    private int clickedCol;

    public Input(ChessBoardGui chessBoardGui) {
        this.chessBoardGui = chessBoardGui;
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {
  
    }
    @Override
public void mousePressed(MouseEvent e) {
    // Calculate clicked row and column
    clickedRow = e.getY() / ChessBoardGui.TILE_SIZE;
    clickedCol = e.getX() / ChessBoardGui.TILE_SIZE;

    // Select a piece at the clicked location
    Piece piece = chessBoardGui.getPiece(clickedRow, clickedCol);

    if (piece != null && chessBoardGui.selectedPiece == null) {
        // Attempting to select a piece
        if (ChessBoardGui.isCurrentPlayerTurn(piece)) {
            // Selecting a piece of the current player
            System.out.println("Selecting a piece");
            chessBoardGui.selectedPiece = piece;
        } else {
            // Attempted to select an opponent's piece
            System.out.println("Cannot select opponent's piece");
        }
    } else if (chessBoardGui.selectedPiece != null) {
        // Attempting to move or capture
        if (ChessBoardGui.isCurrentPlayerTurn(chessBoardGui.selectedPiece)) {
            chessBoardGui.move = new Move(chessBoardGui, chessBoardGui.selectedPiece, clickedRow, clickedCol);

            if (Logic.isMoveValid(chessBoardGui, chessBoardGui.selectedPiece, clickedRow, clickedCol)) {
                Box destinationBox = new Box(clickedCol, clickedRow);

                if (piece == null) {
                    // Move to an empty square
                    System.out.println("I'm moving to an empty square");
                } else if (!ChessBoardGui.isCurrentPlayerTurn(piece)) {
                    // Capture the opponent's piece
                    System.out.println("I'm capturing");
                    chessBoardGui.pieceList.remove(piece);
                } else {
                    // Attempted to move to a square occupied by the player's own piece
                    System.out.println("I cannot move to a square occupied by me");
                    return;
                }

                // Move the selected piece
                chessBoardGui.selectedPiece.setBox(destinationBox);
                chessBoardGui.selectedPiece = null;
                chessBoardGui.setEndTurn();
            } else {
                // Invalid move
                System.out.println("I can't do that");
            }
        } else {
            // Attempted to move when it is not the player's turn
            System.out.println("It's not my turn");
        }
    }

    chessBoardGui.repaint();
}


    @Override
    public void mouseReleased(MouseEvent e) {

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
        // if (isCurrentPlayerTurn(chessBoardGui.selectedPiece)) {
        //     if (chessBoardGui.selectedPiece != null) {
        //         int row = e.getY() / ChessBoardGui.TILE_SIZE;
        //         int col = e.getX() / ChessBoardGui.TILE_SIZE;
        //         if (chessBoardGui.inChessBoard(row, col)) {
        //             chessBoardGui.selectedPiece.setBox(new Box(col, row));
        //             chessBoardGui.repaint();
        //         }
        //     }
        // }
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