package utility.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoundedArrayQueueTest {
	
	private BoundedArrayQueue<Integer> q;
	
	@Before
	public void before() {
		q=new BoundedArrayQueue<>(4);
	}
	@Test
	public void testEmpty() {
		assertEquals(true, q.isEmpty());
		assertEquals(0, q.size());
	}
	@Test(expected = IllegalStateException.class)
	public void testFirstEmpty() {
		q.first();
	}
	@Test
	public void testFirstNotEmpty(){
		q.enqueue(2);
		assertEquals(false, q.isEmpty());
	}
	@Test
	public void testFirst(){
		q.enqueue(3);
		q.enqueue(9);
		assertEquals(new Integer(3), q.first());
	}
	@Test
	public void testDequeue() {
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(5);
		assertEquals(new Integer(2), q.dequeue());
		q.dequeue();
		assertEquals(1, q.size());
	}	
	@Test(expected = IllegalStateException.class)
	public void testDequeueEmpty() {
		q.dequeue();
	}
	@Test(expected = IllegalStateException.class)
	public void testDequeueExtraEmpty() {
		q.enqueue(1);
		assertEquals(new Integer(1), q.dequeue());
		q.dequeue();
	}
	@Test
	public void testEnqueue(){
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(3);
		assertEquals(4, q.size());
		assertEquals(new Integer(2), q.dequeue());
	}
	@Test(expected = IllegalStateException.class)
	public void testEnqueueFull(){
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(8);
	}
	@Test
	public void testIndexOfEmpty(){
		assertEquals(-1, q.indexOf(3));
	}
	@Test
	public void testIndexOf() {
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(3);
		assertEquals(3, q.indexOf(3));
	}
	@Test
	public void testSizeEpty(){
		assertEquals(0, q.size());
	}
	@Test
	public void testSize() {
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(3);
		assertEquals(4, q.size());	
	}

}
