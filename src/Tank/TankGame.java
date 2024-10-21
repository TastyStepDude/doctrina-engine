package Tank;

import Doctrina.Canvas;
import Doctrina.CollidableRepository;
import Doctrina.Game;
import Doctrina.StaticEntity;

import java.util.ArrayList;

public class TankGame extends Game {
    private GamePad gamePad;
    private Tank tank;
    private ArrayList<Missile> missiles;
    private ArrayList<Brick> bricks;

    @Override
    protected void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        missiles = new ArrayList<>();
        bricks = new ArrayList<>();
        bricks.add(new Brick(500, 100));
        bricks.add(new Brick(400, 100));
        bricks.add(new Brick(300, 100));
        bricks.add(new Brick(200, 100));
        bricks.add(new Brick(100, 100));
        bricks.add(new Brick(450, 200));
    }

    @Override
    protected void update() {
        if (gamePad.isQuitPressed()){
            stop();
        }
        if (gamePad.isFirePressed() && tank.canFire()){
            missiles.add(tank.fire());
        }
        tank.update();

        ArrayList<StaticEntity> killedEntities = new ArrayList<>(); //TODO: clear every update instead
        for (Missile missile: missiles){
            missile.update();
            for (Brick brick : bricks){ //TODO: isoler dans les différentes class
                if (missile.hitBoxIntersectWith(brick)){
                    killedEntities.add(missile);
                    killedEntities.add(brick);
                }
            }
        }

        for (StaticEntity killedEntity : killedEntities) {//TODO: replace with better code, maybe an interface could be nice
            if (killedEntity instanceof Brick) {
                bricks.remove(killedEntity);
            }
            if (killedEntity instanceof Missile) {
                missiles.remove(killedEntity);
            }
        }
        CollidableRepository.getInstance().unregisterEntities(killedEntities);
    }

    @Override
    protected void draw(Canvas canvas) {
        tank.draw(canvas);
        for (Missile missile: missiles){
            missile.draw(canvas);
        }
        for (Brick brick: bricks) {
            brick.draw(canvas);
        }
    }
}
