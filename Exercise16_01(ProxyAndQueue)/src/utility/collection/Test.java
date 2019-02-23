package utility.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;

public class Test {

	
	private BoundedArrayQueue<Integer> q;
	
	@Before
	public void before() {
		q=new BoundedArrayQueue<>(4);
	}
	@org.junit.jupiter.api.Test
	public void testEmpty() {
		assertEquals(true, q.isEmpty());
		assertEquals(0, q.size());
		
	}
	@org.junit.jupiter.api.Test
	public void testFirstEmpty() {
		assertThrows(IllegalStateException.class, () -> q.first());
	}
	@org.junit.jupiter.api.Test
	public void testFirstNotEmpty()
	{
		q.enqueue(2);
		assertEquals(false, q.isEmpty());
	}

	@org.junit.jupiter.api.Test
	public void testFirstExtraNotEmpty()
	{
		q.enqueue(3);
		q.enqueue(9);
		assertEquals(new Integer(3), q.first());
	}
	@org.junit.jupiter.api.Test
	public void testDequeue() {
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(5);
		assertEquals(new Integer(2), q.dequeue());
		q.dequeue();
		assertEquals(1, q.size());
	}
	
	@org.junit.jupiter.api.Test
	public void testDequeueEmpty() 
	{
		assertThrows(IllegalStateException.class, () ->q.dequeue());
	}
	@org.junit.jupiter.api.Test
	public void testDequeueExtraEmpty() 
	{
		q.enqueue(1);
		q.enqueue(3);
		assertEquals(new Integer(1), q.dequeue());
		q.dequeue();
		assertThrows(IllegalStateException.class, () ->q.dequeue());
	}
	
	@org.junit.jupiter.api.Test
	public void testEnqueue()
	{
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
	
	@org.junit.jupiter.api.Test
	public void testEnqueueFull()
	{
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(4);
		q.enqueue(3);
		assertThrows(IllegalStateException.class, () ->q.enqueue(8));
	}
	
	@org.junit.jupiter.api.Test
	public void testIndexOf()
	{
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
	
	@org.junit.jupiter.api.Test
	public void size()
	{
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
