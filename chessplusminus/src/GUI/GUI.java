package GUI;

import javax.swing.*;
import java.awt.*;

public interface GUI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("C+-: Custom Chess");
        frame.setLayout(new GridBagLayout());

        // Maximize the frame to fullscreen
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Create and add the chess board panel
        ChessBoardGui board = new ChessBoardGui();
        frame.add(board);

        // Configure the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Optional: You can set this to true if you want to allow resizing
        frame.setVisible(true);
    }
}
