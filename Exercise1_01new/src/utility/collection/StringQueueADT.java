package utility.collection;

public interface StringQueueADT {
	
	public void enqueue(String element);
	public String dequeue();
	public int indexOf(String element);
	public boolean isEmpty();
	public int size();
}
