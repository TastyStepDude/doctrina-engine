package FootPrint;

import Doctrina.Canvas;
import Doctrina.Game;

public class FootPrintGame extends Game {
    private GamePad gamePad;
    private Player player;
    @Override
    protected void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()){
            stop();
        }
        player.update();
    }

    @Override
    protected void draw(Canvas canvas) {
        player.draw(canvas);
    }
}
