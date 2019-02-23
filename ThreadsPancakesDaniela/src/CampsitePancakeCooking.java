import javafx.scene.AmbientLight;

public class CampsitePancakeCooking implements PancakeCooking{

	private int avaliableBakingPlates;
	private int batterLeft;
	private int maxBatter;
	private int minCups;
	
	public CampsitePancakeCooking(int noOfBakingPlates, int maxBatter, int minCups) {
		avaliableBakingPlates=noOfBakingPlates;
		batterLeft=0;
		this.maxBatter=maxBatter;
		this.minCups=minCups;
	}
	public synchronized void takeBakingPlate() {
		while(avaliableBakingPlates<1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" has taken a plate.");
		notifyAll();
		avaliableBakingPlates--;
	}
	public synchronized void pourBatterOnBakingPlate() {
		while(batterLeft<1) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" has poured batter.");
		notifyAll();
		batterLeft--;
	}
	public synchronized void putBackBakingPlate() {
		System.out.println(Thread.currentThread().getName()+" has returned a plate.");
		notifyAll();
		avaliableBakingPlates++;
	}
	public synchronized void mixABowlOfPancakeBatter() {
		while(avaliableBakingPlates>minCups) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public synchronized void refillBowl(int numberOfCups) {
		System.out.println(Thread.currentThread().getName()+" has refilled the bowl with "+numberOfCups+" cups.");
		notifyAll();
		batterLeft+=numberOfCups;
	}
	public synchronized void makeAPancake() {
		System.out.println(Thread.currentThread().getName()+" is making a pancake.");
	}
	public synchronized void eatAPancake() {
		System.out.println(Thread.currentThread().getName()+" is eating a pancake.");
	}
	public synchronized int getBatterLeft() {
		return batterLeft;
	}
	public synchronized int getMaxBatter() {
		return maxBatter;
	}
}
