package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerTimer extends JPanel {
    private int timeInSeconds;
    protected Timer timer;
    private JLabel label;
    private boolean endTurn;

    public PlayerTimer(int initialTimeInSeconds) {
        this.timeInSeconds = initialTimeInSeconds;
        this.label = new JLabel();
        this.label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 24)); // Set font size here
        this.add(label);
        this.endTurn = false;

        // Create and start the timer
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
    }

    private void updateTime() {
        if (timeInSeconds > 0) {
            timeInSeconds--;
            int minutes = timeInSeconds / 60;
            int seconds = timeInSeconds % 60;
            label.setText(String.format("%02d:%02d", minutes, seconds));
        } else {
            label.setText("Time's up!");
            timer.stop();
            endTurn = true;
            handleGameOver();
        }
    }

    public static void handleGameOver() {
        JFrame gameOverFrame = new JFrame("Game Over");
        gameOverFrame.setLayout(new BorderLayout());

        JLabel gameOverLabel;

        if (ChessBoardGui.isWhiteTurn) {
            gameOverLabel = new JLabel("Black Wins!", SwingConstants.CENTER);
        } else {
            gameOverLabel = new JLabel("White Wins!", SwingConstants.CENTER);
        }

        gameOverLabel.setFont(new Font(gameOverLabel.getFont().getName(), Font.BOLD, 24));

        JPanel buttonPanel = new JPanel();
        JButton rematchButton = new JButton("Rematch");
        JButton exitButton = new JButton("Exit Game");

        rematchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rematchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Close the current game over frame
                        gameOverFrame.dispose();
                        // Restart the game by opening the main chess frame again
                        GUI.startGame();
                    }
                });
                
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the game
            }
        });

        buttonPanel.add(rematchButton);
        buttonPanel.add(exitButton);

        gameOverFrame.add(gameOverLabel, BorderLayout.CENTER);
        gameOverFrame.add(buttonPanel, BorderLayout.SOUTH);

        gameOverFrame.setSize(300, 150);
        gameOverFrame.setLocationRelativeTo(null); // Center the frame on the screen
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOverFrame.setVisible(true);
    }

    public void setEndTurn(boolean endTurn) {
        this.endTurn = endTurn;
        if (ChessBoardGui.isWhiteTurn) {
            GUI.player1Timer.timer.start();
            GUI.player2Timer.timer.stop();
        } else {
            GUI.player2Timer.timer.start();
            GUI.player1Timer.timer.stop();
        }
    }

    public boolean isEndTurn() {
        return endTurn;
    }
}
