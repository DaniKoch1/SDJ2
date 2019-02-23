package utility.collection;

public class ArrayQueue<T> implements QueueADT<T>{
	private static final int DEAFULT_CAPACITY=100;
	   private T[] queue;
	   private int count;
	   private int front;
	   
	   public ArrayQueue(int initialCapacity)
	   {
	      queue= (T[]) new Object[initialCapacity];
	      count=0;
	      front=0;
	   }
	   public ArrayQueue()
	   {
		  queue= (T[]) new Object[DEAFULT_CAPACITY];
	      count=0;
	      front=0;
	   }
	   public int size()
	   {
	      return count;
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
	      else
	      {
	         expandCapacity();
	         enqueue(element);
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
	   public void expandCapacity()
	   {
	      T[] queue2=(T[]) new Object[size()*2];
	      for(int i=0;i<size();i++)
	      {
	         queue2[i]=queue[i];
	      }
	      queue=queue2;
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
