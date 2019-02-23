package utility.collection;

public class ThreadSafeBoundedQueue <T> implements QueueADT<T>{
	
	private BoundedArrayQueue<T> q;
	public ThreadSafeBoundedQueue(int capacity) {
		q=new BoundedArrayQueue<>(capacity);
	}
	@Override
	public synchronized void enqueue(T element) {
		q.enqueue(element);
		
	}

	@Override
	public synchronized T dequeue() {
		return q.dequeue();
	}

	@Override
	public synchronized int indexOf(T element) {
		return q.indexOf(element);
	}

	@Override
	public synchronized boolean isEmpty() {
		return q.isEmpty();
	}

	@Override
	public synchronized int size() {
		return q.size();
	}
	
	public synchronized String toString() {
		return q.toString();
	}
	@Override
	public synchronized T first() {
		return q.first();
	}

}
