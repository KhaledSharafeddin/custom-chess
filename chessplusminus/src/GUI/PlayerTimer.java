package GUI;

//PlayerTimer.java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerTimer extends JPanel {
    private int timeInSeconds;
    protected Timer timer;
    private JLabel label;
    // private Player player;
    private boolean endTurn;

    public PlayerTimer(int initialTimeInSeconds) { // Player player to be added
        // this.player = player;
        this.timeInSeconds = initialTimeInSeconds;
        this.label = new JLabel();
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
        }
    }
   public void setEndTurn(boolean endTurn) {
        this.endTurn = endTurn;
        if(ChessBoardGui.isWhiteTurn){
            GUI.player1Timer.timer.start();
            GUI.player2Timer.timer.stop();
            
        }else{
            GUI.player2Timer.timer.start();
            GUI.player1Timer.timer.stop();
        }
    }

    public boolean isEndTurn() {
        return endTurn;
    }

    // public Player getPlayer() {
    // return player;
}