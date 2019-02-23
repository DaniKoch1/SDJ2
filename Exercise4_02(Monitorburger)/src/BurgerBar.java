import java.io.Console;

public class BurgerBar {

	private int numberOfBurgers;
	private int maxNumberOfBurgers;
	private int allHasEaten=0;
	
	public BurgerBar (int maxNoOfBurgers)
	{
		this.maxNumberOfBurgers = maxNoOfBurgers;
		numberOfBurgers = 0;
	}
	
	public synchronized void makeBurger(String employeeName)
	{
		while (numberOfBurgers>=maxNumberOfBurgers)
		{
			try
			{
				System.out.println(employeeName + " is ready to prepare a burger (" +
						numberOfBurgers + " left)");

				wait();
			}
			catch (InterruptedException e)
			{
				//..
			}		
		}
		notifyAll();
		numberOfBurgers++;
		System.out.println("Burger is prepared by "+employeeName+numberOfBurgers);
	}
	
	public synchronized void eatBurger (String who)
	{
		while (numberOfBurgers<1)
		{
			try
			{
				System.out.println(who + " is ready to eat a burger (" +
						numberOfBurgers + " left)");

				wait();
			}
			catch (InterruptedException e)
			{
				//..
			}
		}
		notifyAll();
		numberOfBurgers--;
		System.out.println("Burger is eaten by "+who+numberOfBurgers);
		
	}
	
	public synchronized int getNumberOfBurgers()
	{
		return numberOfBurgers;
	}
	public synchronized void setAllHasEaten(int whatever)
	{
		allHasEaten=whatever;
		System.out.println("Has eaten equals "+allHasEaten);
		if(allHasEaten==5)
			System.exit(0);
	}
	public synchronized int getAllHasEaten()
	{
		return allHasEaten;
	}
}
