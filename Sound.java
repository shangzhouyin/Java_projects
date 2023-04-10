
/*This class pass the music file, create clip to start, play and loop the music*/
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[100];

    public Sound() {
        soundURL[0] = getClass().getResource("Legends_Monsters_and_Heroes/LegendsNeverDie.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem
                    .getAudioInputStream(new File("Legends_Monsters_and_Heroes/LegendsNeverDie.wav"));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {

        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

}
