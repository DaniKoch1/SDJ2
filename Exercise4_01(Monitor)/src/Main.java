
public class Main {
	
	public static void main(String[] args) {
		Counter counter = new Counter(5,25);
		CounterIncrementer incrementer1 = new CounterIncrementer(counter, 200);
		CounterIncrementer incrementer2 = new CounterIncrementer(counter, 200);
		CounterDecrementer decrementer1 = new CounterDecrementer(counter, 200);
		CounterDecrementer decrementer2 = new CounterDecrementer(counter, 200);
	
		Thread thread1 = new Thread(incrementer1);
		Thread thread2 = new Thread(incrementer2);
		Thread thread3 = new Thread(decrementer1);
		Thread thread4 = new Thread(decrementer2);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
}
