package asteroids;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class Rock
{
    private AffineTransform identity = new AffineTransform();
    private double rockHeading = 0;//in radians
    private double rockSpeed;
    private double rockXspeed = 0;
    private double rockYspeed = 0;
    double rockXpos = 200;
    double rockYpos = 200;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int[] rockXpoints =
    {
        0, 3, 3, 0, -2, -2, 0
    };
    int[] rockYpoints =
    {
        -3, -1, 0, 2, 0, -1, -3
    };
    Polygon rockOutline = new Polygon(rockXpoints, rockYpoints, rockXpoints.length);

    public Rock()
    {
        int edge = (int) (Math.random() * 4) + 1;
        rockSpeed = Math.random() * 5;
        
        switch (edge)
        {
            case 1: //top
                rockXpos = Math.random() * width;
                rockYpos = 0;
                rockHeading = (Math.random() * 180) + 90;
                System.out.println("top" + (int)rockHeading);
                break;
            case 2: //right
                rockXpos = width;
                rockYpos = Math.random();
                rockHeading = (Math.random() * 180) + 0;
                System.out.println("right" + (int)rockHeading);
                break;
            case 3: //bottom
                rockXpos = Math.random();System.out.println("bottom" + rockHeading);
                rockYpos = height;
                rockHeading = (Math.random() * 180) + 90;
                System.out.println("bottom" + (int)rockHeading);
                break;
            case 4: //left
                rockXpos = 0;
                rockYpos = Math.random();
                rockHeading = (Math.random() * 180) + 180;
                System.out.println("left" + (int)rockHeading);
                break;
        }
        rockXspeed = rockSpeed * Math.sin(rockHeading);
        rockYspeed = rockSpeed * -Math.cos(rockHeading);
    }

    public void paintself(Graphics2D g2)
    {
        g2.setTransform(identity);
        g2.setColor(Color.WHITE);
        g2.translate(rockXpos, rockYpos);
        g2.scale(30, 30);
        g2.fill(rockOutline);
        g2.setStroke(new BasicStroke(.5f));
        g2.draw(rockOutline);
    }

    public void moveSelf()
    {
        rockYpos = rockXspeed + rockYpos;
        rockXpos = rockYspeed + rockXpos;
    }
}
