package GUI;

import Game.Game;
import java.awt.*;
import javax.swing.*;

public class GUI {
    static PlayerTimer player1Timer;
    static PlayerTimer player2Timer;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("C+-: Custom Chess");
        frame.setLayout(new BorderLayout());

        // Create a panel for the chess board with FlowLayout to center it
        JPanel chessPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ChessBoardGui board = new ChessBoardGui();
        chessPanel.add(board);

        // Create player timers
        player1Timer = new PlayerTimer(5 * 60); // 5 minutes for player 1
        player2Timer = new PlayerTimer(5 * 60); // 5 minutes for player 2

        // Create panels for player timers with labels
        JPanel player1Panel = createPlayerPanel("Player 1's Timer", player1Timer);
        JPanel player2Panel = createPlayerPanel("Player 2's Timer", player2Timer);



        // Create move count labels
        JLabel player1MoveCountLabel = new JLabel("Move Count for Black: " + Game.player2.moveCount, SwingConstants.CENTER);
        JLabel player2MoveCountLabel = new JLabel("Move Count for White: " + Game.player1.moveCount, SwingConstants.CENTER);

        // Create a panel to hold move count labels
        JPanel moveCountPanel = new JPanel(new GridLayout(2, 1));
        moveCountPanel.add(player1MoveCountLabel);
        moveCountPanel.add(player2MoveCountLabel);

        // Add player timer panels and move count panel to the frame
        frame.add(player1Panel, BorderLayout.WEST);
        frame.add(moveCountPanel, BorderLayout.CENTER);
        frame.add(player2Panel, BorderLayout.EAST);

        // Add the chess panel to the center of the frame
        frame.add(chessPanel, BorderLayout.SOUTH);

        // Configure the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    // Helper method to create player timer panels with labels
    private static JPanel createPlayerPanel(String labelText, PlayerTimer playerTimer) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText, SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);
        panel.add(playerTimer, BorderLayout.CENTER);
        return panel;
    }
}