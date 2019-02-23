package utility.collection;

public class QueueListBased<T> implements QueueADT<T>{

	private ListADT<T> list;
	
	public QueueListBased() {
		list = new ArrayList<T>();
	}
	@Override
	public void enqueue(T element) {
		list.add(element);
		
	}

	@Override
	public T dequeue() {
		int index=list.size()-1;
		return list.remove(index);
	}

	@Override
	public T first() {
		return list.get(0);
	}

	@Override
	public int indexOf(T element) {
		return list.indexOf(element);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}
	
}
