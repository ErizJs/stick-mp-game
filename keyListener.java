import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyListener extends KeyAdapter {
	
	Player p;
	
	public keyListener(Player player) {
		p = player;
		
	}
	
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}
	
}
