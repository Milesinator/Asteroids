package asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Asteroids extends JComponent implements ActionListener, KeyListener
{
    JFrame space;
    Rock asteroid;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    Rocket starCruiser;
    static Asteroids controller;
    Timer ticker;

    public static void main(String[] args)
    {
        controller = new Asteroids();
        controller.getGoing();
    }

    public void getGoing()
    {
        ticker = new Timer(20, this);
        ticker.start();
        starCruiser = new Rocket();
        asteroid = new Rock();
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
        starCruiser.paintself(g2);
        asteroid.paintself(g2);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        repaint();
        starCruiser.moveSelf();
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
            starCruiser.setRocketXspeed(starCruiser.getRocketXspeed() - 1);
//            starCruiser.setRocketYspeed(starCruiser.getRocketYspeed() - 1);
        }

        if (ke.getKeyCode() == 38)//checking for up arrow
        {
            starCruiser.setRocketXspeed(starCruiser.getRocketXspeed() + 1);
//            starCruiser.setRocketYspeed(starCruiser.getRocketYspeed() + 1);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
    }
}
