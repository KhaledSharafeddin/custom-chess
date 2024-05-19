package GUI;

import javax.swing.*;
import Game.SoundPlayer;
import java.awt.*;

public class GUI {
    static PlayerTimer player1Timer;
    static PlayerTimer player2Timer;

    public static void main(String[] args) {

        // Create the main frame
        JFrame frame = new JFrame("C+-: Custom Chess");
        frame.setLayout(new BorderLayout());
        SoundPlayer.playSound("move.mp3");

        // Create a panel for the chess board with FlowLayout to center it
        JPanel chessPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ChessBoardGui board = new ChessBoardGui();
        chessPanel.add(board);

        // Create player timers
        player1Timer = new PlayerTimer(5 * 60); // 5 minutes for player 1
        player2Timer = new PlayerTimer(5 * 60); // 5 minutes for player 2

        // Create move count labels
        JLabel player1MoveCountLabel = new JLabel("Move Count: ", SwingConstants.CENTER);
        JLabel player2MoveCountLabel = new JLabel("Move Count: ", SwingConstants.CENTER);

        // Create labels for player timers
        JLabel player1TimerLabel = new JLabel("Player 1's Timer", SwingConstants.CENTER);
        JLabel player2TimerLabel = new JLabel("Player 2's Timer", SwingConstants.CENTER);

        // Create panels for player 1 components
        JPanel player1Panel = createPlayerPanel(player1TimerLabel, player1Timer, player1MoveCountLabel);

        // Create panels for player 2 components
        JPanel player2Panel = createPlayerPanel(player2TimerLabel, player2Timer, player2MoveCountLabel);

        // Add panels to the frame
        frame.add(player1Panel, BorderLayout.WEST);
        frame.add(player2Panel, BorderLayout.EAST);
        frame.add(chessPanel, BorderLayout.CENTER);

        // Configure the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    // Helper method to create panels for player components
    private static JPanel createPlayerPanel(JLabel playerLabel, PlayerTimer playerTimer, JLabel moveCountLabel) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(playerLabel, gbc);

        gbc.gridy = 1;
        panel.add(playerTimer, gbc);

        gbc.gridy = 2;
        panel.add(moveCountLabel, gbc);

        return panel;
    }
}
