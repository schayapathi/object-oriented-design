import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      ArrayList<MoveableShape> shapes = new ArrayList<MoveableShape>();

      MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
      MoveableShape shape2 = new CarShape(20, 20, CAR_WIDTH);

      shapes.add(shape);
      shapes.add(shape2);

      ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
      ShapeIcon icon2 = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);

      JLabel label = new JLabel(icon);
      JLabel label2 = new JLabel(icon2);
      frame.setLayout(new FlowLayout());
      frame.add(label);
      frame.add(label2);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, event ->
         {
            for(MoveableShape m : shapes)
            {
               m.move();
               label.repaint();
               label2.repaint();
            }
      
         });
      t.start();
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}