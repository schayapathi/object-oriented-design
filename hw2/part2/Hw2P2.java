import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class Hw2P2
{

//DataModel aggregates a bunch of Observers
//Observer implements TextView and GraphView

	public static BufferedReader br;
	public static PrintWriter pw;

	public static void main(String[]args)
	{
		DataModel dm = new DataModel();
		//read input values from file whose name is given in args[0]
		try
		{
			br = new BufferedReader(new FileReader(new File(args[0])));
		}catch (FileNotFoundException exception)
		{
			exception.getMessage();
		}
		String line;
		try
		{
			while((line = br.readLine())!=null)
			{
				dm.addValue(Integer.parseInt(line));
			}
		}catch (IOException exception)
		{
			exception.getMessage();
		}

		TextView tv = new TextView(dm);
		GraphView gv = new GraphView(dm);

		dm.addObserver(tv);
		dm.addObserver(gv);

		JFrame textFrame = new JFrame();
		textFrame.setSize(250, 325);
		textFrame.setContentPane(tv);

		JFrame graphFrame = new JFrame();
		//graphFrame.setSize(250, 325);
		graphFrame.setContentPane(gv);
		graphFrame.setBounds(251, 0, 250, 325);

		textFrame.show();
		graphFrame.show();

		textFrame.addWindowListener(new
			WindowAdapter()
			{
				public void windowClosing(WindowEvent event)
				{
					try
					{
						pw = new PrintWriter(new FileWriter(args[0]));
						for(Integer i : dm.model)
						{
							pw.println(String.valueOf(i));
						}
						pw.close();
					}catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			});
		
		graphFrame.addWindowListener(new
			WindowAdapter()
			{
				public void windowClosing(WindowEvent event)
				{
					try
					{
						pw = new PrintWriter(new FileWriter(args[0]));
						for(Integer i : dm.model)
						{
							pw.println(String.valueOf(i));
						}
						pw.close();
					}catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			});
	}
}