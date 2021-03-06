package asteroids;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class Rocket
{
    private double rocketHeading = 0;//in radians
    private double rocketXspeed = 0;
    private double rocketYspeed = 3;
    AffineTransform rocketAffineTransform;
    private AffineTransform identity = new AffineTransform();
    double rocketXpos = 200;
    private double rocketSpeed;
    double rocketYpos = 200;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int[] rocketXpoints =
    {
        0, 2, 2, 2, 2, 6, 2, 2, 1, 1, -1, -1, -2, -2, -6, -2, -2, -2, -2, 0
    };
    int[] rocketYpoints =
    {
        -5, -3, -4, -3, -2, 2, 2, 4, 4, 3, 3, 4, 4, 2, 2, -2, -3, -4, -3, -5
    };
    Polygon rocketOutline = new Polygon(rocketXpoints, rocketYpoints, rocketXpoints.length);

    public AffineTransform paintself(Graphics2D g2)
    {
        g2.setColor(Color.WHITE);
        g2.drawString((int) Math.toDegrees(rocketHeading) + "", 1000, 200);
        g2.translate(rocketXpos, rocketYpos);
        g2.scale(10, 10);
        g2.rotate(rocketHeading);
        g2.setColor(new Color(0, 128, 255));
        g2.fill(rocketOutline);
        g2.setColor(Color.MAGENTA);
        g2.setStroke(new BasicStroke(.5f));
        g2.draw(rocketOutline);
        g2.scale(.1, .1);
        rocketAffineTransform = g2.getTransform();
        return rocketAffineTransform;
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
        rocketXspeed = getRocketSpeed() * Math.sin(rocketHeading);
        rocketXpos = rocketXspeed + rocketXpos;
        rocketYspeed = getRocketSpeed() * -Math.cos(rocketHeading);
        rocketYpos = rocketYspeed + rocketYpos;
        if (rocketYpos > height)
        {
            rocketYpos = 0;
        }
        if (rocketXpos > width)
        {
            rocketXpos = 0;
        }
        if (rocketXpos < 0)
        {
            rocketXpos = width;
        }
        if (rocketYpos < 0)
        {
            rocketYpos = height;
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

    public void setRocketSpeed(double rocketSpeed)
    {
        this.rocketSpeed = rocketSpeed;
    }

      public double getRocketSpeed()
    {
        return rocketSpeed;
    }
}
