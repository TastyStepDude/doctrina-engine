package Viking;

import Doctrina.Canvas;
import Doctrina.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tree extends StaticEntity {
    private final String SPRITE_PATH = "images/tree.png";

    private Image image;

    public Tree() {
        load();
        teleport(300, 300);
    }

    public void load(){ //TODO: refactor, same thing as world
        try {
            image = ImageIO.read(
                    this.getClass().getClassLoader().getResourceAsStream(SPRITE_PATH)
            );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //System.out.println("TOUJOURS EXECUTER");
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawImage(image, x, y);
    }
}
