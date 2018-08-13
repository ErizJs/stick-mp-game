import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Write a description of class Spider here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spider extends Enemy
{
    public Spider(int x, int y) {
        super(x, y);
        iconState = new ImageIcon("spider.png");
        velocityX = 0;
        velocityY = 0;
        damage = 1;
        speed = 3;
    }
}
