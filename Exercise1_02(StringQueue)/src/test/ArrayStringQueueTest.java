package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utility.collection.ArrayStringQueue;

public class ArrayStringQueueTest {
	
	ArrayStringQueue q;
	@Before
	public void before() {
	q=new ArrayStringQueue(3);
	}
	@Test
	public void testSizeZero() {
		assertEquals(0, q.size());
	}
	@Test
	public void testIsEmpty() {
		assertEquals(true, q.isEmpty());
	}
	@Test (expected = IllegalStateException.class)
	public void testDequeueEmpty()
	{
		q.dequeue();
	}
	@Test (expected = IllegalStateException.class)
	public void testFirstEmpty()
	{
		q.first();
	}
	@Test
	public void testExpandCapacity()
	{
		for(int i=0;i<3;i++)
			q.enqueue("Love");
		assertEquals(3, q.size());
		q.enqueue("Smile");
		assertEquals(4, q.size());
		assertEquals(false, q.isEmpty());
	}
	@Test
	public void testIndexOf()
	{
		q.enqueue("Love");
		q.enqueue("Laugh");
		q.enqueue("Live");
		assertEquals(1, q.indexOf("Laugh"));
	}
	@Test (expected=IllegalStateException.class)
	public void testIndexOfNone()
	{
		q.enqueue("Smile");
		q.enqueue("Happy");
		q.enqueue("Happiness");
		q.dequeue();
		q.indexOf("Smile");
	}
}
