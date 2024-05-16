package GUI;

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
        clickedRow = e.getY() / ChessBoardGui.TILE_SIZE;
        clickedCol = e.getX() / ChessBoardGui.TILE_SIZE;

        // ... (existing code handling piece selection and movement)

        chessBoardGui.repaint(); // Repaint the board after any changes
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Optional: Handle initiating dragging a piece (if applicable)
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Optional: Handle completing a dragging action (if applicable)
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Optional: Visual effect when mouse enters the board
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Optional: Visual effect when mouse exits the board
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Optional: Implement dragging functionality (if applicable)
    }

    // Implement the required method from MouseMotionListener
    @Override
    public void mouseMoved(MouseEvent e) {
        int row = e.getY() / ChessBoardGui.TILE_SIZE;
        int col = e.getX() / ChessBoardGui.TILE_SIZE;

        // Optional: Implement visual effects based on mouse position (e.g., highlight potential moves)
        // You can use this method to highlight squares where the selected piece could potentially move
        // if validMoves is not null (meaning a piece is selected).
        if (chessBoardGui.selectedPiece != null ) {
            // Code to highlight valid moves visually (optional)
        }
    }
}
