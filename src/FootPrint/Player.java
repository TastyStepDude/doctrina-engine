package FootPrint;

import Doctrina.Canvas;
import Doctrina.ControllableEntity;
import Doctrina.MovableEntity;

import java.awt.*;

public class Player extends ControllableEntity {
    public Player(GamePad gamePad) {
        super(gamePad);
        teleport(200, 200);
        setDimension(20, 20);
        setSpeed(3);
    }

    @Override
    public void update() {
        moveWithController();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }

    public Footprint layFootprint() {
        return new Footprint(x, y);
    }
}
