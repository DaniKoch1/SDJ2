

public interface QueueADT<T> {

	public void enqueue(T element);
	public T dequeue();
	public int indexOf(T element);
	public T first();
	public boolean isEmpty();
	public int size();
	public boolean isFull();
}
