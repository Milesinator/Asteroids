package asteroids;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.sound.sampled.Line;

public class Bullet
{
    double bulletXpos = 500;
    double bulletYpos = 500;
    double bulletSpeed;
    double bulletCourse;
    AffineTransform bulletAffineTransform;
    Rectangle2D.Double bulletShape = new Rectangle2D.Double(0, 0, 4, 2);

    public Bullet(AffineTransform rocketAffineTransform)
    {
        bulletAffineTransform = rocketAffineTransform;
    }

    public void paintself(Graphics2D g2)
    {
        g2.setTransform(bulletAffineTransform);
        g2.setColor(Color.WHITE);
        g2.fill(bulletShape);
        System.out.println();
        g2.setTransform(new AffineTransform());
    }

    public void moveSelf()
    {
    }
}
