package asteroids;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Rocket
{
    private double rocketHeading = 0;//in degrees
    private double rocketXspeed = 5; 
    private double rocketYspeed = 0;
    double rocketXpos = 200;
    double rocketYpos = 200;
    int[] rocketXpoints =
    {
        0, 2, 2, 2, 2, 6, 2, 2, 1, 1, -1, -1, -2, -2, -6, -2, -2, -2, -2, 0
    };
    int[] rocketYpoints =
    {
        -5, -3, -4, -3, -2, 2, 2, 4, 4, 3, 3, 4, 4, 2, 2, -2, -3, -4, -3, -5
    };
    Polygon rocketOutline = new Polygon(rocketXpoints, rocketYpoints, rocketXpoints.length);

    public void paintself(Graphics2D g2)
    {
        g2.translate(rocketXpos, rocketYpos);
        g2.scale(10, 10);
        g2.rotate(rocketHeading);
        g2.setColor(new Color(0, 128, 255));
        g2.fill(rocketOutline);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(.5f));
        g2.draw(rocketOutline);
    }

    public double getRocketHeading()
    {
        return rocketHeading;
    }

    public void setRocketHeading(double rocketHeading)
    {
        this.rocketHeading = rocketHeading;
    }

    public void moveSelf()
    {
        rocketXpos = rocketXpos + rocketXspeed;
        if (rocketXpos > 2000)
        {
            rocketXpos = 0;
        }
    }        

    public double getRocketXspeed()
    {
        return rocketXspeed;
    }

    public void setRocketXspeed(double rocketXspeed)
    {
        this.rocketXspeed = rocketXspeed;
    }

    public double getRocketYspeed()
    {
        return rocketYspeed;
    }

    public void setRocketYspeed(double rocketYspeed)
    {
        this.rocketYspeed = rocketYspeed;
    }
}
