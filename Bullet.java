import java.awt.Graphics2D;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Write a description of class Bullet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bullet extends Entity

{
    
    public Bullet(int x, int y)
    {
        super(x, y);
        iconState = new ImageIcon("bullet.png");
    }
    
    public void update()
    {
       x += velocityX;
       y += velocityY;
       isColliding();
    }
    
    public void isColliding()
    {
        ArrayList<Enemy> enemies = WaveModeFrame.getEnemyList();
        for (int i = 0; i < enemies.size(); i++)
        {
            Enemy tempEnemy = enemies.get(i);
            if (getBounds().intersects(tempEnemy.getBounds()))
            {
                if(tempEnemy instanceof Skeleton)
                {
                    killBasicEnemy(tempEnemy);
                }
                
                if(tempEnemy instanceof Zombie)
                {
                    killBasicEnemy(tempEnemy);
                }
                
                if(tempEnemy instanceof Spider)
                {
                    killBasicEnemy(tempEnemy);
                }
                
                if(tempEnemy instanceof AwokenBlueJ)
                {
                    WaveModeFrame.removeBullet(this);
                    tempEnemy.removeHealth(5);
                }
            }
        }
    }
    
    public void killBasicEnemy(Enemy enemy){
        WaveModeFrame.removeEnemy(enemy);
        WaveModeFrame.removeBullet(this);
        WaveModeFrame.addScore(3);
        WaveModeFrame.addEnemyKilled();
        if(WaveModeFrame.getEnemiesKilled() % 5 == 0){
            WaveModeFrame.getPlayer().addHealth(3);
        }
    }
}
