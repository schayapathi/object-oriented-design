import java.util.*;
import javax.swing.event.*;

/**
	This class is the part of the program that serves as the model.
	It stores the data in an ArrayList of Strings and is implemented
	using ChangeListeners.
**/

public class Model
{
	public ArrayList<String> data;
	public ArrayList<ChangeListener> listeners;

	public Model(){
       data = new ArrayList<String>();
       listeners = new ArrayList<ChangeListener>();
    }

    public void add(String text){
        data.add(text);
        ChangeEvent listener = new ChangeEvent(this);
        for(ChangeListener listen: listeners){
            listen.stateChanged(listener);
        }
    }

    public void addChangeListener(ChangeListener listener)
    {
      listeners.add(listener);
    }

    public String toString(Model data){
        String result = "";
        for(int i=0; i!= data.data.size()-1;i++)
        {
            result += data.data.get(i).toString();
        }
    	return result;
	}
}