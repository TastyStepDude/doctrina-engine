package Tank;

import Doctrina.Canvas;
import Doctrina.ControllableEntity;
import Doctrina.MovementController;

import java.awt.*;

public class Tank extends ControllableEntity {
    private final int MAX_COOLDOWN = 40;
    private int cooldown = 0;
    public Tank(MovementController controller){
        super(controller);
        setDimension(30, 30);
        setSpeed(3);
        teleport(300, 300);
    }

    public Missile fire() {
        cooldown = MAX_COOLDOWN;
        return new Missile(this);
    }

    public boolean canFire(){
        return cooldown <= 0;
    }

    @Override
    public void update() {
        moveWithController();
        cooldown--;
        if (cooldown < 0) {
            cooldown = 0;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.GREEN);
        int cooldownWidth = cooldown * width / MAX_COOLDOWN;
        if (cooldownWidth != 0) {
            canvas.drawRectangle(x, y - 5, cooldownWidth, 2, Color.red);
        }

    }
}
