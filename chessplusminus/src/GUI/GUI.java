package GUI;

import javax.swing.*;

import Game.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    static PlayerTimer player1Timer;
    static PlayerTimer player2Timer;

    public static void startGame(){
        JFrame mainMenuFrame = new JFrame("C+- Custom Chess");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Create the custom panel for the background
        BackgroundPanel mainPanel = new BackgroundPanel("/res/chess.gif");

        // Create the welcome message label
        JLabel welcomeLabel = new JLabel("C+- Custom Chess", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setOpaque(false); // Make the label background transparent
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Create the panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.setOpaque(false); // Make the button panel background transparent

        // Create the buttons
        JButton standardChessButton = new JButton("Standard Chess");
        JButton customChessButton = new JButton("Custom Chess");
        JButton rulesButton = new JButton("Game Rules");

        // Add action listeners to the buttons
        standardChessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenuFrame.dispose();
                // Call the method to open the main chess frame with standard mode
                openMainChessFrame(false);
            }
        });

        customChessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenuFrame.dispose();
                // Call the method to open the main chess frame with custom mode
                openMainChessFrame(true);
            }
        });

        rulesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the rules in a new frame
                showRulesFrame();
            }
        });

        // Add the buttons to the button panel
        buttonPanel.add(standardChessButton);
        buttonPanel.add(customChessButton);
        buttonPanel.add(rulesButton);

        // Add the button panel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the startup frame
        mainMenuFrame.add(mainPanel);

        // Make the startup frame visible
        mainMenuFrame.setVisible(true);
    }

    // Custom JPanel to display a GIF background
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String filePath) {
            // Load the background image
            ImageIcon icon = new ImageIcon(getClass().getResource(filePath));
            this.backgroundImage = icon.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Draw the background image
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    

    // Method to show the rules in a new frame
    private static void showRulesFrame() {
        JFrame rulesFrame = new JFrame("Game Rules");
        rulesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String rulesText = "<html>" +
                "<h1>Welcome to C+- Custom Chess!</h1>" +
                "<h2>Here are the basic rules:</h2>" +
                "<ol>" +
                "<li>Each player starts with 16 pieces: 1 king, 1 queen, 2 rooks, 2 knights, 2 bishops, and 8 pawns.</li>" +
                "<li>The objective of the game is to checkmate your opponent's king.</li>" +
                "<li>Pieces move according to their specific rules. Here are the moves for each piece:</li>" +
                "<ul>" +
                "<li><img src='" + GUI.class.getResource("/Piece/pieces/pawn.png") + "'/> Pawn: Pawns move forward one square but capture diagonally. On their first move, pawns have the option to move forward two squares.</li>" +
                "<li><img src='" + GUI.class.getResource("/Piece/pieces/rook.png") + "'/> Rook: Rooks move horizontally or vertically any number of squares.</li>" +
                "<li><img src='" + GUI.class.getResource("/Piece/pieces/knight.png") + "'/> Knight: Knights move in an L-shape: two squares in one direction and then one square in a perpendicular direction.</li>" +
                "<li><img src='" + GUI.class.getResource("/Piece/pieces/bishop.png") + "'/> Bishop: Bishops move diagonally any number of squares.</li>" +
                "<li><img src='" + GUI.class.getResource("/Piece/pieces/queen.png") + "'/> Queen: Queens combine the moves of rooks and bishops, moving horizontally, vertically, or diagonally any number of squares.</li>" +
                "<li><img src='" + GUI.class.getResource("/Piece/pieces/king.png") + "'/> King: Kings move one square in any direction.</li>" +
                "</ul>" +
                "<li>Check occurs when a player's king is under threat of capture. The player must move the king out of check, block the check, or capture the threatening piece.</li>" +
                "<li>Checkmate occurs when a player's king is in check and there are no legal moves to escape check. The game ends immediately, and the player in checkmate loses.</li>" +
                "</ol>" +
                "<p>For more detailed rules and strategies, consult a comprehensive chess guide or tutorial.</p>" +
                "</html>";

        JEditorPane rulesPane = new JEditorPane("text/html", rulesText);
        rulesPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(rulesPane);
        rulesFrame.add(scrollPane);
        rulesFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        rulesFrame.setVisible(true);
    }


    
    

    // Method to open the main chess frame
    private static void openMainChessFrame(boolean isCustomMode) {
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
    
        // Create a label for captured pieces
        JLabel capturedPiecesLabel = new JLabel("Captured Pieces", SwingConstants.CENTER);
        capturedPiecesLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0)); // Add padding to the bottom
        panel.add(capturedPiecesLabel, BorderLayout.SOUTH);
    
        return panel;
    }
}

