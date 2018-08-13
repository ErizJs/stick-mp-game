import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Write a description of class AwokenBlueJ here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class AwokenBlueJ extends Enemy
{
    private ImageIcon iconStateRight;
    private ImageIcon iconStateLeft;
    
    public AwokenBlueJ(int x, int y) {
        super(x, y);
        iconState = new ImageIcon("awokenBlueJRight.png");
        iconStateRight = new ImageIcon("awokenBlueJRight.png");
        iconStateLeft = new ImageIcon("awokenBlueJLeft.png");
        velocityX = 0;
        velocityY = 0;
        damage = 50;
        speed = 2;
        health = 3000;
    }
    
    public void update() {
        if(health > 0){
        
            y = y + velocityY;
            x = x + velocityX;
        
            if(this.getX() > WaveModeFrame.getPlayer().getX() && this.getY() > WaveModeFrame.getPlayer().getY()){
                this.setVelX(-speed);
                this.setVelY(-speed);
                iconState = iconStateLeft;
            }
        
            if(this.getX() < WaveModeFrame.getPlayer().getX() && this.getY() > WaveModeFrame.getPlayer().getY()){
                this.setVelX(speed);
                this.setVelY(-speed);
                iconState = iconStateRight;
            }
        
            if(this.getX() < WaveModeFrame.getPlayer().getX() && this.getY() < WaveModeFrame.getPlayer().getY()){
                this.setVelX(speed);
                this.setVelY(speed);
                iconState = iconStateRight;
            }
        
            if(this.getX() > WaveModeFrame.getPlayer().getX() && this.getY() < WaveModeFrame.getPlayer().getY()){
                this.setVelX(-speed);
                this.setVelY(speed);
                iconState = iconStateLeft;
            }
           
        }
        else{
                WaveModeFrame.removeEnemy(this);
                WaveModeFrame.addScore(1000);
                WaveModeFrame.getPlayer().addMaxHP(100 + 100*(WaveModeFrame.getWave()/15));
                WaveModeFrame.getPlayer().addHealth(WaveModeFrame.getPlayer().getMaxHP());
                WaveModeFrame.addEnemyKilled();
                
                Player.addBulletCount();
            }
    }
    
    public void draw(Graphics2D g2) {
        
        g2.drawImage(getImg(), x, y, null);
        g2.setColor(Color.BLACK);
        g2.drawString("Awoken Blue Jay", x, y-35);
        g2.drawString("Health: " + this.getHealth(), x, y-20);
    }
    
    
}


