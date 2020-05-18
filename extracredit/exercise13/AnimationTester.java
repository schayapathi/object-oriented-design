package exercise13;

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
	public static ArrayList<MoveableShape> shapes = new ArrayList<MoveableShape>();
	public static ArrayList<ShapeIcon> icons = new ArrayList<ShapeIcon>();
	public static ArrayList<JLabel> labels = new ArrayList<JLabel>();
	public static JFrame frame;
	
	public static void addShape(CarShape car)
	{
		shapes.add(car);
	}
   
   
   public static void main(String[]args)
	{
		  frame = new JFrame();
	      frame.setSize(1000, 700);
	      shapes = new ArrayList<MoveableShape>();
	      icons = new ArrayList<ShapeIcon>();
	      labels = new ArrayList<JLabel>();

	      Thread car1 = new Thread(new Animator(0, 1));
		  car1.start();
		  Thread car2 = new Thread(new Animator(15, 4));
		  car2.start();
		  Thread car3 = new Thread(new Animator(30, 2));
		  car3.start();
		  Thread car4 = new Thread(new Animator(45, 5));
		  car4.start();
		  Thread car5 = new Thread(new Animator(60, 3));
		  car5.start();

	      for(MoveableShape s: shapes)
	      {
	    	  icons.add(new ShapeIcon(s, ICON_WIDTH, ICON_HEIGHT));
	      }
	      
	      for(ShapeIcon i: icons)
	      {
	    	  labels.add(new JLabel(i));
	      }
	      
	      
	      frame.setLayout(new FlowLayout());
	      
	      
	      for(JLabel l: labels)
	      {
	    	  frame.add(l);
	      }
	      
	      
	      frame.setVisible(true);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	}


   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}