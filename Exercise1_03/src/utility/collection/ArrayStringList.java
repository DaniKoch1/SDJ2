package utility.collection;

public class ArrayStringList implements StringListADT {
	private final static int DEFAULT_CAPACITY = 100;
	private String[] list;
	private int size;
	
	public ArrayStringList (int initialCapacity)
	{
		list = new String[initialCapacity];
		size = 0;
	}
	
	public ArrayStringList ()
	{
		list = new String[DEFAULT_CAPACITY];
		size = 0;
	}
	
	public void add (int index, String element)
	{
		if (list.length>index)
		{
			if (list[index]==null)
			{
				size++;
			}
			list[index] = element;			
		}
	}
	public void add (String element)
	{
		for (String e: list)
		{
			if (e == null)
			{
				e = element;
				size++;
				break;
			}
		}
		// exception
	}
	public void set (int index, String element)
	{
		add(index, element);
	}
	public String get (int index)
	{
		return list[index];
	}
	public String remove (int index)
	{
		String returnString = list[index];
		list[index] = null;
		size--;
		return returnString;
	}
	public String remove (String element)
	{
		for (String e: list)
		{
			if (e.equals(element))
			{
				String returnString = e;
				e = null;
				size--;
				return returnString;
			}
		}
		throw new IllegalStateException();
	}
	public int indexOf (String element)
	{
		for (int i=0;i<size();i++)
		{
			if (list[i].equals(element))
			{
				return i;
			}
		}
		return -1;
	}
	public boolean contains (String element)
	{
		if (indexOf(element) == -1)
		{
			return false;
		}
		return true;
	}
	public boolean isEmpty ()
	{
		if (size>0)
		{
			return false;
		}
		return true;
	}
	public boolean isFull()
	{
		return size==list.length;
	}
	public int size()
	{
		return size;
	}
	public String toString ()
	{
		String returnString = "[ ";
		for (String e: list)
		{
			if (e != null)
			{
				returnString += e + " , ";
			}
		}
		returnString.substring(0, returnString.length()-2);
		returnString += "]";
		return returnString;
	}
}
