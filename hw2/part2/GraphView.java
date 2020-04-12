import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class GraphView extends JPanel implements Observer
{
	private static final int HEIGHT = 20;
	private ArrayList<Integer> graphModel = new ArrayList<Integer>(DataModel.model);

	public GraphView (DataModel aModel)
	{
		addMouseListener(new
			MouseAdapter()
			{
				public void mousePressed(MouseEvent event)
				{
					int x = event.getX();
					int y = event.getY();
					//System.out.println("x: " + x + " y: " + y);
					graphModel.set(y/30, x);
					//System.out.println("index: "+ y/30 + " width: "+x);
					aModel.setValue(graphModel);
					//repaint();
				}
			});
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(int i = 0; i < 10; i++)
		{
			int startY = i*30;
			g2.drawRect(0, startY, DataModel.model.get(i).intValue(), HEIGHT);
		}
		
	}

	public void update(Observable obs, Object obj)
	{
		//System.out.println("updating bars");
		graphModel = (ArrayList<Integer>)obj;
		repaint();
	}
	
}
