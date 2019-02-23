
public class BlockingQueue<T> implements Buffer<T> {

	private QueueADT<T> q;
	
	public BlockingQueue(int capacity) {
		q=new BoundedArrayQueue<>(capacity);
	}
	@Override
	public synchronized void put(T element) {
		if(element!=null)
		{
			while(isFull())
			{
				try {
					wait();
				}
			catch(InterruptedException e)
				{}
			}
			notifyAll();
			q.enqueue(element);
		}
		else
			throw new IllegalStateException();
	}

	@Override
	public synchronized T take() {
		while(isEmpty())
		{
			try {
				wait();
			}
			catch(InterruptedException e)
			{}
		}
		notifyAll();
		return q.dequeue();
	}

	@Override
	public synchronized T look() {
		if(!(isEmpty()))
			return q.first();
		else
			return null;
	}

	@Override
	public synchronized boolean isEmpty() {
		return q.isEmpty();
	}

	@Override
	public synchronized boolean isFull() {
		return q.isFull();
	}

	@Override
	public synchronized int size() {
		return q.size();
	}

}
