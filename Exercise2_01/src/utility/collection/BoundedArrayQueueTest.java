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
	public void testFirstNotEmpty()
	{
		q.enqueue(2);
		assertEquals(false, q.isEmpty());
	}

	@Test
	public void testFirstExtraNotEmpty()
	{
		q.enqueue(3);
		q.enqueue(9);
		assertEquals(new Integer(3), q.first());
	}
	@Test
	public void testDequeue() {
		q.enqueue(2);
		q.enqueue(3);
		assertEquals(new Integer(2), q.dequeue());
		q.dequeue();
		assertEquals(1, q.size());
	}

}
