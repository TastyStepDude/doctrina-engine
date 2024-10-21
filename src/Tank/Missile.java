package Tank;

import Doctrina.Canvas;
import Doctrina.CollidableRepository;
import Doctrina.Direction;
import Doctrina.MovableEntity;

import java.awt.*;

public class Missile extends MovableEntity {
    private final Direction tankDirection;
    public Missile(Tank tank) {
        //setDirection(tank.getDirection());
        tankDirection = tank.getDirection();
        initialize(tank);
        CollidableRepository.getInstance().registerEntity(this);
    }

    private void initialize(Tank tank) {
        setSpeed(5);
        if (tankDirection == Direction.RIGHT){
            setDimension(8, 4);
            teleport(tank.getX() + tank.getWidth(), tank.getY() + tank.getWidth() / 2 - height / 2);
        }
        if (tankDirection == Direction.LEFT){
            setDimension(8, 4);
            teleport(tank.getX(), tank.getY() + tank.getWidth() / 2 - height / 2);
        }
        if (tankDirection == Direction.UP){
            setDimension(4, 8);
            teleport(tank.getX() + tank.getWidth() / 2 - width / 2, tank.getY());
        }
        if (tankDirection == Direction.DOWN){
            setDimension(4, 8);
            teleport(tank.getX() + tank.getWidth() / 2 - width / 2, tank.getY() + tank.getHeight());
        }

    }

    @Override
    public void update() {
        move(tankDirection);
        if (x >= 820) {
            x = -20;
        }
        if (y >= 620) {
            y = -20;
        }
        if (x < -20){
            x = 820;
        }
        if (y < -20) {
            y = 620;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.YELLOW);
    }
}
