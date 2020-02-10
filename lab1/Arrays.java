public class Arrays
{
	public static void swapLargestAndSmallest(int[]a)
	{
		int largest = 0;
		int smallest = 0;
		for(int i = 1; i < a.length; i++)
		{
			if (a[largest] < a[i])
				largest = i;
			if (a[smallest] > a[i])
				smallest = i;
		}
		int temp = a[smallest];
		a[smallest] = a[largest];
		a[largest] = temp;
	}
}