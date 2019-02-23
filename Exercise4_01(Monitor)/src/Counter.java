
public class Counter {
	
	private long value;
	private long max;
	private long min;
	
	public Counter (long min, long max)
	{
		value = 0;
		this.max = max;
		this.min = min;
	}
	
	public synchronized void increment(){
		while (value>=max){
			try{
				System.out.println(value + ": " + Thread.currentThread().getName());
				wait();
			}
			catch (InterruptedException e)
			{	}
		}
		value++;
		System.out.println(value);
		notifyAll();
	}
	
	public synchronized void decrement()
	{
		while (value<=min)
		{
			try
			{
				System.out.println(value + ": " + Thread.currentThread().getName());
				wait();
			}
			catch (InterruptedException e)
			{
				//..
			}
		}
		value--;
		System.out.println(value);
		notifyAll();
	}
	
	public synchronized long getValue()
	{
		return value;
	}
}
