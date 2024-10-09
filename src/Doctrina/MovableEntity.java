package Doctrina;

import java.awt.*;

public abstract class MovableEntity extends StaticEntity{
    private int speed = 1;
    private Direction direction = Direction.UP;

    public abstract void update();

    public void move(){
        x += direction.calculateVelocityX(speed);
        y += direction.calculateVelocityY(speed);
    }
    public void move(Direction direction){
        this.direction = direction;
        move();
    }

    public void moveUp(){
        move(Direction.UP);
    }

    public void moveDown(){
        move(Direction.DOWN);
    }

    public void moveLeft(){
        move(Direction.LEFT);
    }

    public void moveRight(){
        move(Direction.RIGHT);
    }

    public Rectangle getHitBox(){
        if (direction == Direction.UP){
            return getUpperHitBox();
        }
        if (direction == Direction.DOWN){
            return getLowerHitBox();
        }
        if (direction == Direction.LEFT){
            return getLeftHitBox();
        }
        if (direction == Direction.RIGHT){
            return getRightHitBox();
        }
        return getBounds();
    }

    private Rectangle getRightHitBox() {
        return new Rectangle(x + width, y, speed, height);
    }

    private Rectangle getLeftHitBox() {
        return new Rectangle(x - speed, y, speed, height);
    }

    private Rectangle getLowerHitBox() {
        return new Rectangle(x, y + height, width, speed);
    }

    private Rectangle getUpperHitBox() {
        return new Rectangle(x, y - speed, width, speed);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
