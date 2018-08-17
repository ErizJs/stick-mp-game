import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Write a description of class Zombie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Zombie extends Enemy
{   
    public Zombie(int x, int y) {
        super(x, y);
        iconState = new ImageIcon("Assets/stickfigHurt.png");
        velocityX = 0;
        velocityY = 0;
        damage = 3;
        speed = 1;
    }
}

