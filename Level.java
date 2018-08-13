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
        JFrame frame = new JFrame("2D Game - Java Course Final Project");
        frame.setSize(1280, 1024);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new WaveModeFrame());
        frame.setVisible(true);
    }
}