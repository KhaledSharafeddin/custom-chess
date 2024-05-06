package GUI;

import javax.swing.*;
import java.awt.*;

public class ChessBoardGui extends JPanel {
    
    public int squareSize = 85;
    int cols = 8;
    int rows = 8;

    public ChessBoardGui(){
        this.setPreferredSize(new Dimension(cols * squareSize, rows * squareSize));
        this.setBackground(Color.green);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for(int r = 0; r < rows; r++)
            for(int c = 0; c<cols; c++){
                g2d.setColor((c + r) % 2 == 0 ? new Color(67,103,149) : new Color(146,205,255));
                g2d.fillRect(c*squareSize, r*squareSize, squareSize, squareSize);
            }
        
    }
}
