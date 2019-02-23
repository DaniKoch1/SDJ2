package utility.collection;

public class BoundedArrayQueue<T> implements QueueADT<T>{

	private T[] queue;
	private int count;
	private int front;
	
	public BoundedArrayQueue (int capacity)
	{
		queue = (T[]) new Object[capacity];
		count = -1;
		front = 0;
	}
	
	public T dequeue ()
	{
		if (size()>0)
		{
			T element = queue[front];
			queue[front]=null;
			if (size()==1)	//if this is last element left in the queue
			{
				count=-1;
				front=0;
			}
			else
			{
				front++;
			}
			return element;			
		}
		throw new IllegalStateException("Queue is empty");
	}
	
	public void enqueue (T element)
	{
		if (size()<queue.length)
		{
			if (count + 1 < queue.length)
			{
				count++;			
				queue[count]=element;				
			}
			else
			{
				count = 0;
				queue[count]=element;
			}
		}
		else
		{
			throw new IllegalStateException("Queue is full");
		}
	}
	
	public T first()
	{
		if (size()>0)
		{
			return queue[front];
		}
		throw new IllegalStateException("Queue is empty");
	}
	
	public int indexOf (T element)
	{
		if (size()<1)
		{
			return -1;
		}
		int tempfront = front; 			//temporal front
		int index = 0;
		while (tempfront != count)
		{
			if (queue[tempfront].equals(element))
			{
				return index;
			}
			if (tempfront + 1 < queue.length)
			{
				tempfront++;
			}
			else
			{
				tempfront=0;
			}
			index++;
		}			
		if (queue[count].equals(element))
		{
			return index;					
		}
		else
		{
			return -1;
		}
	}
	
	public boolean isEmpty ()
	{
		return size()<1;
	}
	
	public int size() {
		if (count>-1)
		{
			if (front<=count)
			{
				return count-front+1;
			}
			else
			{
				return (queue.length-front)+(count+1); 
			}
		}
		else
		{
			return 0;
		}
	}
	
	public String toString ()
	{
		String returnString = "{";
		for (int i = 0;i<size();i++)
		{
			if (front+i<queue.length)
			{
				returnString += queue[front+i]+", ";
			}
			else
			{
				returnString += queue[front+i-queue.length]+", ";
			}
		}
		returnString.substring(0, returnString.length()-2);
		returnString += "}";
		return returnString;
	}
}
