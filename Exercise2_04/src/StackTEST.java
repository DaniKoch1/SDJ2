import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utility.collection.Stack1;

public class StackTEST {

	private StackADT<String> stack;
	
	@Before
	public void setUp() {
		stack = new ArrayStack<>(4);
	}
	@Test
	public void testEmpty() {
		assertEquals(0, stack.size());
		assertEquals(true, stack.isEmpty());
	}
	@Test
	public void testNull() {
		stack.push(null);
		assertEquals(1, stack.size());
	}
	@Test
	public void testDuplicates() {
		stack.push("Hi");
		stack.push("Hi");
		assertEquals(2, stack.size());
	}
	@Test
	public void testFullness() {
		stack.push("Whatever");
		assertEquals(false, stack.isFull());
		stack.push("However");
		assertEquals(5, stack.size());
		
	}
	@Test
	public void testPop() {
		stack.pop();
		assertEquals(4, stack.size());
		assertEquals("Whatever", stack.pop());
	}
	@Test
	public void testPeek() {
		assertEquals("Hi", stack.peek());
		assertEquals(3, stack.size());
		
	}
	@Test
	public void testIndexOfIs() {	
		assertEquals(1, stack.indexOf("Hi"));
	}
	@Test
	public void testIndexOfIsNot() {	
		assertEquals(-1, stack.indexOf("Pear"));
	}
}
