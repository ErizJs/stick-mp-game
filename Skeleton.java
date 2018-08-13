import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Skeleton extends Enemy{
    public Skeleton(int x, int y) {
        super(x, y);
        iconState = new ImageIcon("skeleton.png");
        velocityX = 0;
        velocityY = 0;
        damage = 2;
        speed = 2;
    }
}
