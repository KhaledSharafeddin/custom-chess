package GUI;

import java.awt.event.*;
import java.util.ArrayList;

import Game.SoundPlayer;
import Game.standardGame;
import Game.Box;
import Game.Color;
import Game.Logic;
import Game.Move;
import Piece.Piece;

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
        // System.out.println("Mouse pressed");
        clickedRow = e.getY() / ChessBoardGui.TILE_SIZE;
        clickedCol = e.getX() / ChessBoardGui.TILE_SIZE;
        //System.out.println("Mouse press");

        // Select a piece at the clicked location
        Piece piece = chessBoardGui.getPiece(clickedRow, clickedCol);
        if (piece != null && chessBoardGui.selectedPiece==null) {
            System.out.println("I am assigning");
            chessBoardGui.selectedPiece = piece;   
        }
        else if(ChessBoardGui.isCurrentPlayerTurn(chessBoardGui.selectedPiece)&& chessBoardGui.selectedPiece!=null && piece == null ){
            System.out.println("I am just moving");
            chessBoardGui.move = new Move(chessBoardGui, chessBoardGui.selectedPiece, clickedCol, clickedRow);
            //System.out.println(chessBoardGui.isValidMove(chessBoardGui.move)); 
            if(Logic.isMoveValid(chessBoardGui, chessBoardGui.selectedPiece, clickedRow, clickedCol)){
                Box destinationBox = new Box(clickedCol, clickedRow);
                chessBoardGui.selectedPiece.setBox(destinationBox);
                chessBoardGui.selectedPiece = null;
                chessBoardGui.setEndTurn();
            }    
        }  else if (ChessBoardGui.isCurrentPlayerTurn(chessBoardGui.selectedPiece) && chessBoardGui.selectedPiece != null
        && piece != null)  {
            System.out.println("I am trying to capture");
            chessBoardGui.move = new Move(chessBoardGui, chessBoardGui.selectedPiece, clickedCol, clickedRow);
            //System.out.println(chessBoardGui.isValidMove(chessBoardGui.move)); 
            if(Logic.isMoveValid(chessBoardGui, chessBoardGui.selectedPiece, clickedRow, clickedCol)){
                Box destinationBox = new Box(clickedCol, clickedRow);
                //piece.getPlayer().addToList(piece);
                chessBoardGui.pieceList.remove(piece);
                chessBoardGui.selectedPiece.setBox(destinationBox);
            
                chessBoardGui.selectedPiece = null;
                chessBoardGui.setEndTurn();
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