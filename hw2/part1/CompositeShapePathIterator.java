import java.awt.geom.PathIterator;
import java.util.ArrayList;

public class CompositeShapePathIterator implements PathIterator
{
   private ArrayList<PathIterator> iterators;
   public CompositeShapePathIterator()
   {
      iterators = new ArrayList<>();
   }

   public void add(PathIterator anIterator)
   {
      iterators.add(anIterator);
   }

   public int currentSegment(double[] coords)
   {
      PathIterator currentIterator = iterators.get(0);
      return currentIterator.currentSegment(coords);
   }

   public int currentSegment(float[] coords)
   {
      PathIterator currentIterator = iterators.get(0);
       return currentIterator.currentSegment(coords);
   }

   public int getWindingRule()
   {
      if (isDone()) 
         return 0;
      PathIterator currentIterator = iterators.get(0);
      return currentIterator.getWindingRule();
   }

   public boolean isDone()
   {
      return iterators.size() == 0;
   }

   public void next()
   {
      PathIterator currentIterator = iterators.get(0);
      currentIterator.next();
      if (currentIterator.isDone()) iterators.remove(0);
   }

}