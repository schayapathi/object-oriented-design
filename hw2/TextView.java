import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.util.*;
import java.io.*;

public class TextView extends Box implements Observer
{
	public ArrayList<JTextField> fields = new ArrayList<JTextField>();
	public ArrayList<Integer> textModel;
	public int j;
	public int currentUpdate = -1;
	public int currentChangedUpdate = -1;
	public TextView (DataModel aModel)
	{
		super(BoxLayout.Y_AXIS);
		textModel = new ArrayList<Integer>(aModel.model);

		for(int i = 0; i < 10; i++)
		{
			//System.out.println(textModel.get(i+1));
			fields.add(new JTextField(String.valueOf(textModel.get(i))));
		}

		for(j = 0; j < 10; j++)
		{
			JTextField current = fields.get(j);
			add(current);
			current.setEditable(true);
			current.getDocument().addDocumentListener(new
				DocumentListener()
				{
					public void changedUpdate(DocumentEvent event){}
					public void removeUpdate(DocumentEvent event)
					{
						try
						{
							//System.out.println("trying to parse: " + current.getText());
							textModel.set(current.getY()/30, Integer.parseInt(current.getText()));
							aModel.setValue(textModel);
						}catch (IllegalStateException exception)
						{
							//System.out.println("exception: " + exception.getMessage());
						}catch (NumberFormatException exception)
						{
							exception.getMessage();
						}
					}
					public void insertUpdate(DocumentEvent event)
					{
						try
						{
							//System.out.println("trying to parse: " + current.getText());
							textModel.set(current.getY()/30, Integer.parseInt(current.getText()));
							//System.out.println("parsed: " + current.getText());
							aModel.setValue(textModel);
						}catch (NumberFormatException exception)
						{
							System.out.println("exception: " + exception.getMessage());
						}
					}
				});
		}
	}
	
	
	public void update(Observable obs, Object obj)
	{
		/*System.out.println("updating fields");
		textModel = (ArrayList<Integer>)obj;
		for(int i = 0; i < 10; i++)
		{
			currentUpdate = i;

			if(currentChangedUpdate != i)
			{
				fields.get(i).setText(String.valueOf(textModel.get(i)));
				System.out.println(String.valueOf(textModel.get(i)));
			}

			currentUpdate = -1;
		}*/

		//System.out.println("updating fields");
		textModel = (ArrayList<Integer>)obj;
		for(int i = 0; i < fields.size(); i++)
		{
			try
			{
				if(!String.valueOf(textModel.get(i)).equals(fields.get(i).getText()))
				{
					fields.get(i).setText(String.valueOf(textModel.get(i)));
					System.out.println(String.valueOf(textModel.get(i)));
				}
			}catch (NumberFormatException exception)
			{
				exception.getMessage();
			}

		}
	}
}