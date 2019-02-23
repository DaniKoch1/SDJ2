
public class BurgerBarEmployee implements Runnable {

	private String name;
	private BurgerBar bar;
	
	public BurgerBarEmployee(String name, BurgerBar bar) {
		this.name = name;
		this.bar = bar;
	}
	
	public synchronized void run ()
	{
		while (true)
		{
			bar.makeBurger(name);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
