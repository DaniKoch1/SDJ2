package utility.collection;

public class ArrayQueue <T> implements QueueADT {

	private static final int DEFAULT_CAPACITY=100;
	private T[] queue;
	private int count;
	private int front;
	
	public ArrayQueue(int initialCapacity)
	{
		queue=(T[]) new Object[initialCapacity];
		count=0;
		front=0;
	}
	public ArrayQueue()
	{
		queue=(T[]) new Object[DEFAULT_CAPACITY];
		count=0;
		front=0;
	}
	public void enqueue(Object element)
	{
		queue[count]=(T) element;
		count++;
		if(count==queue.length)
		{
			T[] newQueue= (T[]) new Object[count*2];
			for(int i=front;i<count;i++)
				newQueue[i]=queue[i];
			queue=newQueue;
		}
	}
	public T dequeue()
	{
		if(isEmpty())
			throw new IllegalStateException();
		T first=queue[front];
		queue[front]=null;
		front++;
		return first;
	}
	public T first()
	{
		if(isEmpty())
			throw new IllegalStateException();
		return queue[front];
	}
	public int indexOf(Object element)
	{
		for(int i=front;i<count;i++)
			if(queue[i].equals(element))
				return i;
		throw new IllegalStateException();
	}
	public boolean isEmpty()
	{
		if(queue[front]==null)
			return true;
		return false;
	}
	public int size()
	{
		return count-front;
	}
	public String toString()
	{
		String print="{";
		for(int i=front;i<count-1;i++)
			print+=queue[i]+", ";
		return print+queue[count-1]+"}";
	}

}
