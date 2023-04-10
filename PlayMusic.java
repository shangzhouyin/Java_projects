/*This class is used to control the music, play and stop*/
public class PlayMusic {

    Sound sound = new Sound();
    public PlayMusic() {

    }

    public void playMusic(int i ){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }
}
