
public class BurgerBarCostumer implements Runnable{

	private int burgersToEat;
	private String name;
	private BurgerBar bar;
	
	
	public BurgerBarCostumer(int burgersToEat, String name, BurgerBar bar) {
		this.burgersToEat = burgersToEat;
		this.name = name;
		this.bar = bar;
	}
	
	public synchronized void run()
	{
		while(burgersToEat>0)
		{
			while(bar.getNumberOfBurgers()>0 && burgersToEat>0)
			{
				bar.eatBurger(name);
				burgersToEat--;
				System.out.println(name+" has left " +burgersToEat);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		bar.setAllHasEaten(1+bar.getAllHasEaten());
		System.out.println("*****"+name+" has eaten all his/her burgers");
	}
}
