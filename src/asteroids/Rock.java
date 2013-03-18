package asteroids;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Toolkit;

public class Rock
{
    private double rockHeading = 0;//in radians
    private double rockXspeed = 0;
    private double rockYspeed = 0;
    double rockXpos = 200;
    double rockYpos = 200;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    int[] rockXpoints =
    {
        -5, -1, 3, 6, 6, -3, -1, -5,
    };
    int[] rockYpoints =
    {
        4, 5, 6, 4, 0, 4, -4, -2,
    };
    Polygon rockOutline = new Polygon(rockXpoints, rockYpoints, rockXpoints.length);
    
    public void paintself(Graphics2D g2)
    {
        g2.setColor(Color.WHITE);
        g2.translate(rockXpos, rockYpos);
        g2.scale(10, 10);
        g2.fill(rockOutline);
        g2.setStroke(new BasicStroke(.5f));
        g2.draw(rockOutline);
    }
}
