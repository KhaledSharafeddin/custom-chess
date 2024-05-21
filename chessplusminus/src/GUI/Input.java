package GUI;

import Game.Box;
import Game.Logic;
import Game.Move;
import Piece.Piece;
import Game.Type;
import java.awt.event.*;
import java.awt.BorderLayout;

import javax.swing.JFrame;

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
    
        if (piece != null) {
            if (chessBoardGui.selectedPiece == null) {
                // Selecting a piece for the first time
                if (ChessBoardGui.isCurrentPlayerTurn(piece)) {
                    System.out.println("Selecting me");
                    chessBoardGui.selectedPiece = piece;
                } else {
                    System.out.println("I can't be the enemy :(");
                }
            } else {
                // A piece is already selected
                if (ChessBoardGui.isCurrentPlayerTurn(piece)) {
                    // Deselect the current piece and select a new piece
                    System.out.println("Changing me");
                    chessBoardGui.selectedPiece = piece;
                } else {
                    // Attempted to move or capture
                    System.out.println("I'm trying to move or capture!");
                    chessBoardGui.move = new Move(chessBoardGui, chessBoardGui.selectedPiece, clickedRow, clickedCol);
    
                    if (Logic.isMoveValid(chessBoardGui, chessBoardGui.selectedPiece, clickedRow, clickedCol)) {
                        Box destinationBox = new Box(clickedCol, clickedRow);
    
                        if (piece == null) {
                            // Move to an empty square
                            System.out.println("I'm moving to an empty square");
                        } else if (!ChessBoardGui.isCurrentPlayerTurn(piece)) {
                            // Capture the opponent's piece
                            System.out.println("I'm capturing, watch me!!");
                            //chessBoardGui.getPlayer(piece.getColor()).addToEnemyList(piece);
                            if(piece.getType() == Type.KING){
                                GUI.handleGameOver();
                            }
                            chessBoardGui.pieceList.remove(piece);
                        } else {
                            // Attempted to move to a square occupied by the player's own piece
                            System.out.println("I can't move to a square occupied with another me");
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
                }
            }
        } else if (chessBoardGui.selectedPiece != null) {
            // Clicked on an empty square while a piece is selected
            chessBoardGui.move = new Move(chessBoardGui, chessBoardGui.selectedPiece, clickedRow, clickedCol);
    
            if (Logic.isMoveValid(chessBoardGui, chessBoardGui.selectedPiece, clickedRow, clickedCol)) {
                Box destinationBox = new Box(clickedCol, clickedRow);
                chessBoardGui.selectedPiece.setBox(destinationBox);
                chessBoardGui.selectedPiece = null;
                chessBoardGui.setEndTurn();
            } else {
                // Invalid move
                System.out.println("I can't do that :(");
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