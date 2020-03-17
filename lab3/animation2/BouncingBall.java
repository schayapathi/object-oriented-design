import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;


public class BouncingBall {
	
	public static void main (String[]args)
	{
		JFrame frame = new JFrame();

		MoveableShape shape = new BallShape(50, 50);

		ShapeIcon icon = new ShapeIcon(shape, 400, 100);

		JLabel label = new JLabel(icon);

		frame.setLayout(new FlowLayout());

		frame.add(label);

      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.pack();
      	frame.setVisible(true);

		final int DELAY = 100;
      	// Milliseconds between timer ticks
      	Timer t = new Timer(DELAY, event ->
        {
            shape.move();
            label.repaint();
        });
      	t.start();

	}

	
}
