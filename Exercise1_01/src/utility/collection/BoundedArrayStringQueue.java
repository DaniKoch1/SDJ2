package utility.collection;

public class BoundedArrayStringQueue implements StringQueueADT
{
   private String[] queue;
   private int count;
   private int front;
   
   public BoundedArrayStringQueue(int capacity)
   {
      queue=new String[capacity];
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
   public String first() throws IllegalStateException
   {
      if(!isEmpty())
         return queue[front];
      else
         throw new IllegalStateException();
   }
   public void enqueue(String element)
   {
      if(count<queue.length)
      {
         queue[count]=element;
         count++;
      }
   }
   public String dequeue() throws IllegalStateException
   {
      if(!isEmpty())
      {
         String first=first();
         queue[front]=null;
         front++;
         return first;
      }
      else
         throw new IllegalStateException();
   }
   public int indexOf(String element)
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
