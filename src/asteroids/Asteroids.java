 package asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Asteroids extends JComponent implements Runnable, ActionListener, KeyListener
{
    JFrame space;
    Rock asteroid;
    double rocketXpos;
    double rocketYpos;
    AffineTransform rocketAffineTransform;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;                                                                                                                                              
    Rocket starCruiser;
    static Asteroids controller;
    Timer ticker;
    Timer asteroidTicker;
    ArrayList<Rock> rockStorage = new ArrayList<Rock>();
    ArrayList<Bullet> bulletStorage = new ArrayList<Bullet>();

    public static void main(String[] args)
    {
        controller = new Asteroids();
        SwingUtilities.invokeLater(controller);
    }

    @Override
    public void run()
    {
        ticker = new Timer(20, this);
        ticker.start();
        asteroidTicker = new Timer(1000, this);
        asteroidTicker.start();
        starCruiser = new Rocket();
        space = new JFrame("Asteroids");
        space.setBackground(Color.BLACK);
        space.setVisible(true);
        space.setSize(width, height);
        space.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        space.addKeyListener(this);
        space.add(this);
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        rocketAffineTransform = starCruiser.paintself(g2);
        for(Rock r : rockStorage)
        {
            r.paintself(g2);
            r.moveSelf();
        }
        for(Bullet b : bulletStorage)
        {
            b.paintself(g2);
            b.moveSelf();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        repaint();
        starCruiser.moveSelf();
        if (ae.getSource() == asteroidTicker)
        {
            rockStorage.add(new Rock());
        }
    }
    @Override
    public void keyTyped(KeyEvent ke)
    {
    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        if (ke.getKeyCode() == 39)//checking for right arrow, increases heading  
        {
            starCruiser.setRocketHeading(starCruiser.getRocketHeading() + Math.toRadians(2));
            if (starCruiser.getRocketHeading() > Math.toRadians(359))
            {
                starCruiser.setRocketHeading(starCruiser.getRocketHeading() - Math.toRadians(360));
            }
        }

        if (ke.getKeyCode() == 37)//checking for left arrow
        {
            starCruiser.setRocketHeading(starCruiser.getRocketHeading() + Math.toRadians(-2));
            if (starCruiser.getRocketHeading() < 0)
            {
                starCruiser.setRocketHeading(starCruiser.getRocketHeading() + Math.toRadians(360));
            }
        }

        if (ke.getKeyCode() == 40)//checking for down arrow
        {
            starCruiser.setRocketSpeed(starCruiser.getRocketSpeed() - 1);
        }

        if (ke.getKeyCode() == 38)//checking for up arrow
        {
            starCruiser.setRocketSpeed(starCruiser.getRocketSpeed() + 1);
        }
        
        if (ke.getKeyCode() == 32)//checking for space bar, fires bullet
        {
            bulletStorage.add(new Bullet(rocketAffineTransform));
        }
    }
    
    
    @Override
    public void keyReleased(KeyEvent ke)
    {
    }
}
