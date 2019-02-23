package utility.collection;

public class ArrayStringQueue implements StringQueueADT {
	private static final int DEFAULT_CAPACITY=100;
	private String[] queue;
	private int count;
	private int front;
	
	public ArrayStringQueue(int initialCapacity)
	{
		queue=new String[initialCapacity];
		count=0;
		front=0;
	}
	public ArrayStringQueue()
	{
		queue=new String[DEFAULT_CAPACITY];
		count=0;
		front=0;
	}
	public void enqueue(String element)
	{
		queue[count]=element;
		count++;
		if(count==queue.length)
		{
			String[] newQueue= new String[count*2];
			for(int i=front;i<count;i++)
				newQueue[i]=queue[i];
			queue=newQueue;
		}
	}
	public String dequeue()
	{
		if(isEmpty())
			throw new IllegalStateException();
		String first=queue[front];
		queue[front]=null;
		front++;
		return first;
	}
	public String first()
	{
		if(isEmpty())
			throw new IllegalStateException();
		return queue[front];
	}
	public int indexOf(String element)
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
