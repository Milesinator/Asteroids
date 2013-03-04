package asteroids;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Asteroids extends JComponent
{
    JFrame space;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    
    
    public static void main(String[] args) 
    {
       new Asteroids().getGoing();
    }
    public void getGoing()
    {
        Rocket starCruiser = new Rocket();
        space = new JFrame("Asteroids");
        space.setVisible(true);
        space.setSize(width, height);
        space.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.drawOval(50, 50, 50, 50);
        repaint();
    }
}
