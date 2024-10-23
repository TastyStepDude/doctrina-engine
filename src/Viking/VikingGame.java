package Viking;

import Doctrina.Canvas;
import Doctrina.Game;

import java.awt.*;

public class VikingGame extends Game {
    private GamePad gamePad;
    private Player player;
    private World world;
    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        world = new World();
        world.load();
    }

    @Override
    protected void update() {
        if(gamePad.isQuitPressed()){
            stop();
        }
        player.update();
    }

    @Override
    protected void draw(Canvas canvas) {
        world.draw(canvas);
        player.draw(canvas);
    }
}
