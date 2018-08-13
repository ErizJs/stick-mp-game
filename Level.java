import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Level {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Stick Game");
        frame.setSize(1280, 1024);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JButton single = new JButton("Singleplayer");
        JButton host = new JButton("Host Game");
        JButton join = new JButton("Join Game");
        JPanel mainmenu = new JPanel();
        frame.add(mainmenu);
        frame.setVisible(true);
        mainmenu.add(single);
        mainmenu.add(host);
        mainmenu.add(join);
        class ClickListener implements ActionListener { 
          public void actionPerformed(ActionEvent event) {  
                  Object obj = event.getSource(); 
                  if (obj == single) {
                      frame.getContentPane().removeAll();
                      frame.setVisible(false); // this must be done or no input will be taken
                      frame.getContentPane().add(new WaveModeFrame());
                      frame.setVisible(true);
                      frame.getContentPane().revalidate();
                    }
                    else if (obj == host) {
                        
                    }
                } 
            }
        
        ActionListener listener3 = new ClickListener();
        single.addActionListener(listener3);
      
        ActionListener listener4 = new ClickListener();
        host.addActionListener(listener4);
        
    }
}
