import java.util.*;
import java.awt.*;
import javax.swing.*;


public class CompositeIcon implements Icon 
{
	public ArrayList<Icon> iconList = new ArrayList<Icon>();

	public int getIconHeight()
	{
		return 200;
	}
	public int getIconWidth()
	{
		return 200;
	}
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		int space = 0;
		for(Icon i : iconList)
		{
			i.paintIcon(c, g, x + space, y);
			space += 50;
		}
	}

	public void addIcon(Icon icon)
	{
		iconList.add(icon);
	}
}