package Viking;

import Doctrina.Canvas;
import Doctrina.Game;
import Doctrina.RenderingEngine;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class VikingGame extends Game {
    private GamePad gamePad;
    private Player player;
    private World world;
    private Tree tree;

    private int soundCooldown;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        world = new World();
        world.load();
        tree = new Tree();
        startMusic();//TODO: put in object

        RenderingEngine.getInstance().getScreen().fullscreen();
    }

    private void startMusic() { //TODO: maybe add mixer
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream("audios/music.wav"));
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void update() {
        if(gamePad.isQuitPressed()){
            stop();
        }
        player.update();

        soundCooldown--;
        if (soundCooldown < 0) {
            soundCooldown = 0;
        }

        if (gamePad.isFirePressed() && soundCooldown == 0) {
            soundCooldown = 100;

            //FIRE
            try { //TODO: refactor, put in singleton, AudioSystem
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream("audios/fire.wav"));
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void draw(Canvas canvas) {
        world.draw(canvas);

        // Tree height - switch layer
        // 80 - 20 (max layer) = 52
        if (player.getY() < tree.getY() + 52) {
            player.draw(canvas);
            tree.draw(canvas);
        } else {
            tree.draw(canvas);
            player.draw(canvas);
        }

    }
}
