package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("C+-: Custom Chess");
        frame.setLayout(new BorderLayout());

        // Create a panel for the chess board with FlowLayout to center it
        JPanel chessPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ChessBoardGui board = new ChessBoardGui();
        chessPanel.add(board);

        // Create player timers
        PlayerTimer player1Timer = new PlayerTimer(5 * 60); // 5 minutes for player 1
        PlayerTimer player2Timer = new PlayerTimer(5 * 60); // 5 minutes for player 2

        // Create panels for player timers with labels
        JPanel player1Panel = createPlayerPanel("Player 1's Timer", player1Timer);
        JPanel player2Panel = createPlayerPanel("Player 2's Timer", player2Timer);

        // Add player timer panels to the frame
        frame.add(player1Panel, BorderLayout.WEST);
        frame.add(player2Panel, BorderLayout.EAST);

        // Add the chess panel to the center of the frame
        frame.add(chessPanel, BorderLayout.CENTER);

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
