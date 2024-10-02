package Tank;

import Doctrina.Canvas;
import Doctrina.Direction;
import Doctrina.MovableEntity;

import java.awt.*;

public class Missile extends MovableEntity {
    private final Direction tankDirection;
    public Missile(Tank tank) {
        //setDirection(tank.getDirection());
        tankDirection = tank.getDirection();
        setDimension(10, 10);
        teleport(tank.getX(), tank.getY());
        setSpeed(5);
    }
    @Override
    public void update() {
        move(tankDirection);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.YELLOW);
    }
}
