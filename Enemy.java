
public abstract class Enemy extends Entity {
    protected static int damage;
    protected int speed;
    public Enemy(int x, int y) {
        super(x, y);
        
    }
    
    public static int getDamage(){
        return damage;
    }
    
    public void update() {
        
        y = y + velocityY;
        x = x + velocityX;
        
        if(this.getX() > WaveModeFrame.getPlayer().getX() && this.getY() > WaveModeFrame.getPlayer().getY()){
            this.setVelX(-speed);
            this.setVelY(-speed);
        }
        
        if(this.getX() < WaveModeFrame.getPlayer().getX() && this.getY() > WaveModeFrame.getPlayer().getY()){
            this.setVelX(speed);
            this.setVelY(-speed);
        }
        
        if(this.getX() < WaveModeFrame.getPlayer().getX() && this.getY() < WaveModeFrame.getPlayer().getY()){
            this.setVelX(speed);
            this.setVelY(speed);
        }
        
        if(this.getX() > WaveModeFrame.getPlayer().getX() && this.getY() < WaveModeFrame.getPlayer().getY()){
            this.setVelX(-speed);
            this.setVelY(speed);
        }
    }
}

