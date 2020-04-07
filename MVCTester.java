import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
   This class creates a panel where the user can type into a text field and
   click the add button to add their message to a text area. This program
   is written in the MVC (Model-View-Controller) pattern.
*/
public class MVCTester
{
   public static JFrame frame;
   public static JButton add;
   public static JTextArea area;
   public static JTextField line;

   public static void main(String[] args)
   {
      Model data = new Model();

      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300, 450);
      frame.setTitle("MVC Tester");

      add = new JButton("add");
      add.setPreferredSize(new Dimension(300, 50));

      //Controller tells the model to insert the text that the user typed

      ChangeListener listener = new ChangeListener()
      {
         public void stateChanged (ChangeEvent event)
         {
            //View asks the model for the current text
            area.setText(data.toString(data));
         }
      };
      data.addChangeListener(listener);
      add.addActionListener(new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               String button = event.getActionCommand();
               if(button.equals("add"))
               {
                  area.append(line.getText());
                  area.append("\n");
                  line.setText("");
               }

            }
         }); 

      area = new JTextArea();
      area.setPreferredSize(new Dimension(300, 300));
      area.setEditable(false);

      line = new JTextField();
      frame.add(line);
      line.setPreferredSize(new Dimension(300, 50));
      line.setEditable(true);

      JPanel p = new JPanel();
      p.setLayout(new FlowLayout());
      p.add(add);
      p.add(area);
      p.add(line);

      frame.add(p);
      
      frame.show();

      
   }
}