import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Player extends Entity {
    private int speed = 6;
    private int velocityX, velocityY;
    private int maxHP = 200;
    
    private ImageIcon icLeft;
    private ImageIcon icRight;
    private ImageIcon icHurt;
    
    private int projArrayIndex = 0;
    
    private static int bulletsPerShot = 1;
    
    public Player(int x, int y) {
         super(x, y);
         health = maxHP;
         iconState = new ImageIcon("stickfig.png");
         icRight = new ImageIcon("stickfig.png");
         icLeft = new ImageIcon("stickfig2.png");
         icHurt = new ImageIcon("stickfigHurt.png");
         update();
    }
    
    public void update() 
    {
        y = y + velocityY;
        x = x + velocityX;
        
        if (getHealth() > maxHP){
            health = maxHP;
        }
        
        if(x < 0){
            x = 0;
        }
        
        if (x > 1280-96){
            x = 1280-96;
        }
        
        if (getY() < 0){
            y = 0;
        }
        
        if(getY() > 1024-128){
            y = 1024-128;
        }
    }
    
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_W) 
        {
            velocityY = -speed;
        }
        
        else if(key == KeyEvent.VK_A)
        {
            velocityX = -speed;
            iconState = icLeft;
        }
        
        else if(key == KeyEvent.VK_S)
        {
            velocityY = speed;
        }
        
        else if(key == KeyEvent.VK_D)
        {
            velocityX = speed;
            iconState = icRight;
        }
        else if(key == KeyEvent.VK_SPACE)
        {
            //EasySound gunshot = new EasySound("E:/YourFolder/FinalProject/Files/ambience_background_hum.wav");
            //gunshot.play();
            if(iconState.equals(icLeft)){
                for(int i = 0; i < bulletsPerShot; i++){
                    Bullet tempBullet = new Bullet(x, y + 77);
                    WaveModeFrame.addBullet(tempBullet);
                    tempBullet.setVelX(-8);
                }
            }
            
            else if(iconState.equals(icRight)){
                for(int i = 0; i < bulletsPerShot; i++){
                    Bullet tempBullet = new Bullet(x+96, y + 77);
                    WaveModeFrame.addBullet(tempBullet);
                    tempBullet.setVelX(8);
                }
            }
        }
    }
    
    public void keyReleased(KeyEvent k)
    {
        int key = k.getKeyCode();
        
        if (key == KeyEvent.VK_W) 
        {
            velocityY = 0;
        }
        
        else if(key == KeyEvent.VK_A)
        {
            velocityX = 0;
        }
        
        else if(key == KeyEvent.VK_S)
        {
            velocityY = 0;
        }
        
        else if(key == KeyEvent.VK_D)
        {
            velocityX = 0;
        }   
        
    }
    
    public void isColliding()
    {
        ArrayList<Enemy> enemies = WaveModeFrame.getEnemyList();
        for (int i = 0; i < enemies.size(); i++)
        {
            Enemy tempEnemy = enemies.get(i);
            if (getBounds().intersects(tempEnemy.getBounds()))
            {
                if(tempEnemy instanceof Enemy)
                {
                    removeHealth(Enemy.getDamage());
                }
            }
        }
    }
    
    public int getHealth(){
        return health;
    }
    
    public void addMaxHP(int n){
        maxHP += 100;
    }
    
    public int getMaxHP(){
        return maxHP;
    }
    
    public static void addBulletCount(){
        bulletsPerShot += 10;
    }
}
