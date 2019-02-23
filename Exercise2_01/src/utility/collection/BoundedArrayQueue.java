package utility.collection;

public class BoundedArrayQueue<T> implements QueueADT<T>{
	private T[] queue;
	   private int count;
	   private int front;
	   
	   public BoundedArrayQueue(int capacity)
	   {
	      queue= (T[]) new Object[capacity];
	      count=0;
	      front=0;
	   }
	   public int size()
	   {
	      return queue.length-front;
	   }
	   public boolean isEmpty()
	   {
	      if(size()>0)
	         return false;
	      else
	         return true;
	   }
	   public T first() throws IllegalStateException
	   {
	      if(!isEmpty())
	         return queue[front];
	      else
	         throw new IllegalStateException();
	   }
	   public void enqueue(T element)
	   {
	      if(count<queue.length)
	      {
	         queue[count]=element;
	         count++;
	      }
	   }
	   public T dequeue() throws IllegalStateException
	   {
	      if(!isEmpty())
	      {
	         T first=first();
	         front++;
	         return first;
	      }
	      else
	         throw new IllegalStateException();
	   }
	   public int indexOf(T element)
	   {
	      for(int i=0;i<count;i++)
	         if(queue[i].equals(element))
	            return i;
	      return -1;
	   }
	   public String toString()
	   {
	      String print="{";
	      if(count>1)
	      {
	         for(int i=front;i<count-1;i++)
	            print+=queue[i]+", ";
	      }
	      if(count>0)
	         print+=queue[count-1]+"}";
	      else
	         return "The queue is empty.";
	      return print;
	   }
}
