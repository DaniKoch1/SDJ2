package utility.collection;

public class ArrayStringQueueManuaTest {
	public static void main(String[] args) {
		ArrayStringQueue q=new ArrayStringQueue(3);
		q.enqueue("5");
		q.enqueue("Hey");
		q.enqueue("Blah");
		q.enqueue("Lol");
		System.out.println(q);
		q.dequeue();
		System.out.println(q.size());
		System.out.println(q);
	}
}
