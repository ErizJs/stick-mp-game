import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public abstract class Entity
{
    
    protected int x, y;
    protected int health;
    protected ImageIcon iconState;
    protected int velocityX;
    protected int velocityY;
    
    
    public Entity(int x, int y)
    {
        
        this.x = x;
        this.y = y;
        velocityX = 0;
        velocityY = 0;
        
    }
    
    public abstract void update();
    
    public void draw(Graphics2D g2) {
        
        g2.drawImage(getImg(), x, y, null);
        
    }
    
    public Image getImg() 
    {
        return iconState.getImage();    
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
 
    public void setVelX(int x)
    {
         velocityX = x;
    }
    
    public void setVelY(int y)
    {
        velocityY = y;
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, getImg().getWidth(null), getImg().getHeight(null));
    }
    
    public void addHealth(int hp){
        health += hp;
    }
    
    public void removeHealth(int hp){
        health -= hp;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void setHealth(int hp){
        health = hp;
    }
    
    public boolean isAlive(){
        if(health > 0){
            return true;
        }
        else{
            return false;
        }
    }
}

