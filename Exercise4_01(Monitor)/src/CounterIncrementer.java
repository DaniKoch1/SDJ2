
public class CounterIncrementer implements Runnable {

	private Counter counter;
	private int updates;
	
	public CounterIncrementer(Counter counter, int updates) {
		this.counter = counter;
		this.updates = updates;
	}	
	public synchronized void run (){
		for (int i =0;i<updates;i++){
			counter.increment();
		}
		System.out.println(counter.getValue());
	}
}

