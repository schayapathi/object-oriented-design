import java.awt.*;
import java.awt.geom.*;
import java.util.*;


public class CompositeShape implements Shape
{
   private ArrayList<Shape> shapes;

   public CompositeShape()
   {
      shapes = new ArrayList<>();
   }

   public void add(Shape s)
   {
      shapes.add(s);
   }

   public boolean contains(double x, double y)
   {
      for (Shape s : shapes)
      {
         if (s.contains(x, y)) return true;
      }
      return false;
   }
      
   public boolean contains(double x, double y, double w, double h)
   {
      for (Shape s : shapes)
      {
         if (s.contains(x, y, w, h)) return true;
      }
      return false;
   }
      
   public boolean contains(Point2D p)
   {
      for (Shape s : shapes)
      {
         if (s.contains(p)) return true;
      }
      return false;
   }

   public boolean contains(Rectangle2D r)
   {
      for (Shape s : shapes)
      {
         if (s.contains(r)) 
            return true;
      }
      return false;
   }
      
   public Rectangle getBounds()
   {
      if (shapes.size() == 0) 
         return new Rectangle();
      Shape s = shapes.get(0);
      Rectangle r = s.getBounds();
      for (int i = 1; i < shapes.size(); i++)
      {
         s = shapes.get(i);
         r = r.union(s.getBounds());
      }
      return r;
   }

   public Rectangle2D getBounds2D()
   {
      if (shapes.size() == 0) 
         return new Rectangle2D.Double();
      Shape s = shapes.get(0);
      Rectangle2D r = s.getBounds2D();
      for (int i = 1; i < shapes.size(); i++)
      {
         s = shapes.get(i);
         Rectangle2D.union(r, s.getBounds(), r);
      }
      return r;
   }

   public PathIterator getPathIterator(AffineTransform at)
   {
      CompositeShapePathIterator iterator = new CompositeShapePathIterator();
      for (Shape s : shapes)
      {
         iterator.add(s.getPathIterator(at));
      }
      return iterator;
   }

   public PathIterator getPathIterator(AffineTransform at, double flatness)
   {
      CompositeShapePathIterator iterator = new CompositeShapePathIterator();
      for (Shape s : shapes)
      {
         iterator.add(s.getPathIterator(at, flatness));
      }
      return iterator;
   }

   public boolean intersects(double x, double y, double w, double h)
   {
      for (Shape s : shapes)
      {
         if (s.intersects(x, y, w, h)) return true;
      }
      return false;
   }

   public boolean intersects(Rectangle2D r)
   {
      for (Shape s : shapes)
      {
         if (s.intersects(r)) return true;
      }
      return false;
   }

}