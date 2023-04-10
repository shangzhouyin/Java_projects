/*This is the main class to initialize the game, play and stop music */
public class Main {


    public static void main(String[] args) {

        PlayMusic play = new PlayMusic();
        play.playMusic(0);
        gameInit start = new gameInit();
        start.gameInitialize();
        start.gameMain();
        play.stopMusic();

    }


}