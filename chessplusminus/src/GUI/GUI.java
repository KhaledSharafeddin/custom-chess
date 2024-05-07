package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

        // Create and add player timers
        PlayerTimer player1Timer = new PlayerTimer(5 * 60); // 5 minutes for player 1
        PlayerTimer player2Timer = new PlayerTimer(5 * 60); // 5 minutes for player 2
        frame.add(player1Timer);
        frame.add(player2Timer);

        

        // Configure the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Optional: You can set this to true if you want to allow resizing
        frame.setVisible(true);
    }
}
