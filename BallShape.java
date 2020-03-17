import java.awt.*;
import java.awt.geom.*;
import java.util.*;


public class BallShape implements MoveableShape {
	private int x;
	private int y;

	public BallShape (int x, int y)
	{
		this.x = x;
      	this.y = y;
	}

	public void draw (Graphics2D g2)
	{
		Ellipse2D.Double ball = new Ellipse2D.Double(x, y, 30, 30);
		g2.draw(ball);
	}

	public void move ()
	{
		x++;
		y = (int)(20*Math.sin(x/2)+50);
	}
}



