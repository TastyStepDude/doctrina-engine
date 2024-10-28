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
        SoundEffect.MUSIC.play();

        RenderingEngine.getInstance().getScreen().fullscreen();
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
            SoundEffect.MURLOC.play();
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
