package Game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {
    public static void playSound(String soundFileName) {
        try {
            // Use forward slashes for resource path
            URL soundURL = SoundPlayer.class.getResource("/sounds/" + soundFileName);
            if (soundURL == null) {
                throw new IOException("Sound file not found: " + soundFileName);
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Test the playSound method
        playSound("win.wav");

    }
}
