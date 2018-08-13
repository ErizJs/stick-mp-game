import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;

public class WaveModeFrame extends JPanel implements ActionListener{
    
    
    private Timer mainTimer;
    
    private Timer attackTimer;
    
    private Timer spawnerTimer;
    
    private static Player player;
    
    private int enemyCount = 5;
    
    private int enemySpawnCount = 10;
    
    private static int enemiesKilled = 0;
    
    private static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    
    private static int score = 0;
    
    private Random rand = new Random();
    
    boolean bossSpawned = false;
    
    static ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    
    private int SpawnIterator = 0;
    
    private static int wave = 1;
    
    public WaveModeFrame() 
    {
      setFocusable(true);

                      
      player = new Player(640-96, 512-128);
        
        
        
      addKeyListener(new keyListener(player));
        
        
      mainTimer = new Timer(10, this);
      mainTimer.start();
        
      attackTimer = new Timer(1000, this);
      attackTimer.start();
        
      spawnerTimer = new Timer(10000, this);
      spawnerTimer.start();

        for (int i = 0; i < enemyCount; i++)
        {
            int spawner = rand.nextInt(4);
            if (spawner == 0){
                addEnemy(new Skeleton(rand.nextInt(100), rand.nextInt(1024)));
            }
            
            if (spawner == 1){
                addEnemy(new Zombie(rand.nextInt(1280), rand.nextInt(100)));
            }
            
            if (spawner == 2){
                addEnemy(new Skeleton(rand.nextInt(100)+924, rand.nextInt(1024)));
            }
            
            if (spawner == 3){
                addEnemy(new Spider(rand.nextInt(1280), rand.nextInt(100) + 924));
            }
        }
    }
    
    public void paint(Graphics g)
    {
        if(player.getHealth() > 0 && enemyCount > 0){
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            
            g2.setColor(Color.RED);
            
            g2.drawString("Health: " + player.getHealth() + " / " + player.getMaxHP(), 50, 25);
            
            g2.setColor(Color.BLUE);
        
            g2.drawString("Score: " + score, 50, 50);
            
            g2.drawString("Enemies killed: " + enemiesKilled, 50, 75);
            
            g2.drawString("Wave: " + wave, 50, 100);
            
            g2.drawString("An evil Blue Jay will spawn periodically. Eliminating it will grant extra maximum health.", 50, 125);
            
            g2.drawString("Controls: W, A, S, D to move. Spacebar to shoot.", 50, 150);
            
            player.draw(g2);
        
            for(int i = 0; i < enemyList.size(); i++)
            {
                Enemy enemyInList = enemyList.get(i);
                enemyInList.draw(g2);
            }
        
            for(int i = 0; i < bulletList.size(); i++)
            {
                Bullet bulletInList = bulletList.get(i);
                bulletInList.draw(g2);
            }
        }
        
        else if(player.getHealth() < 0){
                g.setColor(Color.RED);
                Font font = new Font("Serif", Font.BOLD, 36);
                g.setFont(font);
                g.drawString("You have died. Score: " + score, 640, 512);
            }
        
    }
    
    public void actionPerformed(ActionEvent arg0)
    {
        Object src = arg0.getSource();
        if(src == mainTimer){

           player.update();
        
           for(int i = 0; i < enemyList.size(); i++)
           {
             Enemy enemyInList = enemyList.get(i);
             enemyInList.update();
           }
        
           for(int i = 0; i < bulletList.size(); i++)
           {
              Bullet bulletInList = bulletList.get(i);
              bulletInList.update();
              }
        
           super.repaint();
            
        }
        
        if(src == attackTimer){
            player.isColliding();
        }
        
        if(src == spawnerTimer){
            if(SpawnIterator < 5){
                for (int i = 0; i < enemySpawnCount * wave; i++)
                {
                    int spawner = rand.nextInt(4);
                    if (spawner == 0){
                        addEnemy(new Skeleton(rand.nextInt(100), rand.nextInt(1024)));
                    }
            
                    if (spawner == 1){
                        addEnemy(new Zombie(rand.nextInt(1280), rand.nextInt(100)));
                    }
            
                    if (spawner == 2){
                        addEnemy(new Skeleton(rand.nextInt(100)+924, rand.nextInt(1024)));
                    }
            
                    if (spawner == 3){
                        addEnemy(new Spider(rand.nextInt(1280), rand.nextInt(100) + 924));
                    }
                }
                SpawnIterator += 1;
                wave += 1;
            }
            
            else if (SpawnIterator >= 5){
                Enemy boss = new AwokenBlueJ(0, 0);
                boss.setHealth(50*wave);
                addEnemy(boss);
                
                
                SpawnIterator = 0;
                wave+= 1;
           }
       }
    }
    
    public static void addBullet(Bullet b)
    {
        bulletList.add(b);
    }
    
    public static void removeBullet(Bullet b)
    {
        bulletList.remove(b);
    }
    
    public static ArrayList<Bullet> getBulletList(){
        return bulletList;
    }
    
    public void addEnemy(Enemy x)
    {
        enemyList.add(x);
    }
    
    public static void removeEnemy(Enemy x)
    {
        enemyList.remove(x);
    }
    
    public static Player getPlayer(){
        return player;
    }
    
    public static ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }
    
    public static void addScore(int points){
        score += points;
    }
    
    public static void addEnemyKilled(){
        enemiesKilled += 1;
    }
    
    public static int getWave(){
        return wave;
    }
    
    public static int getEnemiesKilled(){
        return enemiesKilled;
    }
}