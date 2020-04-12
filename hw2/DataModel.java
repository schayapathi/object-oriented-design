import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class DataModel extends Observable
{
	public static ArrayList<Integer> model;

	public DataModel()
	{
		model = new ArrayList<Integer>();
	}

	public void addValue(Integer val)
	{
		model.add(val);
	}

	public void setValue(ArrayList<Integer> mod)
	{
		this.model = mod;
		//System.out.println("new value set");
		setChanged();
		notifyObservers(model);
		//System.out.println("notified observers");
	}
	

}