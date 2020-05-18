package exercise13;

import javax.swing.JLabel;

public class Animator implements Runnable{
	CarShape c;
	public Animator(int y, int speed)
	{
		c = new CarShape(0, y, 100, speed);
		AnimationTester.addShape(c);
	}
	public void run()
	{
		while(true)
		{
			c.move();
			for(JLabel l : AnimationTester.labels)
				l.repaint();
			try {
				Thread.sleep(25);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
