package utility.collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test2 {

	private ThreadSafeBoundedQueue<Integer> q;

	@Before
	public void before() {
		q = new ThreadSafeBoundedQueue<>(4);
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
	public void testFirstNotEmpty() {
		q.enqueue(2);
		assertEquals(false, q.isEmpty());
	}

	@Test
	public void testFirstExtraNotEmpty() {
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
		q.enqueue(3);
		assertEquals(new Integer(1), q.dequeue());
		q.dequeue();
		q.dequeue();
	}

	@Test
	public void testEnqueue() {
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(3);
		assertEquals(4, q.size());
		assertEquals(new Integer(2), q.dequeue());
		assertEquals(3, q.size());
		q.enqueue(8);
		assertEquals(4, q.size());
	}

	@Test(expected = IllegalStateException.class)
	public void testEnqueueFull() {
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(8);
	}

	@Test
	public void testIndexOf() {
		assertEquals(-1, q.indexOf(3));
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(3);
		assertEquals(3, q.indexOf(3));
		q.dequeue();
		q.dequeue();
		q.enqueue(3);
		q.enqueue(3);
		assertEquals(1, q.indexOf(3));
		assertEquals(-1, q.indexOf(50));
	}

	@Test
	public void size() {
		assertEquals(0, q.size());
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(3);
		assertEquals(4, q.size());
		q.dequeue();
		assertEquals(3, q.size());
		q.dequeue();
		assertEquals(2, q.size());
		q.enqueue(1);
		q.dequeue();
		assertEquals(2, q.size());
		q.enqueue(14);
		assertEquals(3, q.size());
	}

}
