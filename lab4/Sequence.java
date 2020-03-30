public class Sequence<E> implements Iterator
{
	private E[] array;
	private int index = 0;

	public boolean hasNext()
	{
		if (index >= array.length || array[index] == null)
			return false;
		else
			return true;
	}
	public E next()
	{
		E eObj = array[index];
		index++;
		return eObj;
	}
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}

public class E {
	private int data;

	public E (int data)
	{
		this.data = data;
	}
	public int getData()
	{
		return data;
	}
}
