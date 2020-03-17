import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester
{
   public static int helloClick = 1;
   public static int goodbyeClick = 1;

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FIELD_WIDTH = 20;
      JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");

      JButton helloButton = new JButton("Say Hello");
      JButton goodbyeButton = new JButton("Say Goodbye");
      goodbyeButton.setEnabled(false);

      helloButton.addActionListener(event ->
         textField.setText("Hello " + helloClick++));
      helloButton.addActionListener(event -> helloButton.setEnabled(false));
      helloButton.addActionListener(event -> goodbyeButton.setEnabled(true));


      goodbyeButton.addActionListener(event ->
         textField.setText("Goodbye " + goodbyeClick++));
      goodbyeButton.addActionListener(event -> goodbyeButton.setEnabled(false));
      goodbyeButton.addActionListener(event -> helloButton.setEnabled(true));


      frame.setLayout(new FlowLayout());

      frame.add(helloButton);
      frame.add(goodbyeButton);
      frame.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

   }
}
