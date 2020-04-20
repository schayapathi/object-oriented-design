import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


public class BoxedIcon implements Icon
{
	private Icon icon;

	public BoxedIcon(Icon icon)
	{
		this.icon = icon;
	}

	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.drawRect(x-10, y-10, icon.getIconWidth() + 20, icon.getIconHeight()+20);
		icon.paintIcon(c, g, x, y);
	}
	public int getIconHeight()
	{
		return icon.getIconHeight()+20;
	}
	public int getIconWidth()
	{
		return icon.getIconWidth()+20;
	}
}
