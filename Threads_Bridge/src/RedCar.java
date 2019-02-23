
public class RedCar implements Runnable{
	private Lane bridge;
	
	public RedCar(Bridge bridge) {
		this.bridge=bridge;
	}
	public void run() {
		while(true) {
		bridge.enterFromTheLeft();
		going(1500, 5000);
		bridge.exitToTheRight();
		going(2000,6000);
		}
	}
	private void going(int min, int max)
	{
		long time = (long)(Math.random() * (max - min) + min);
		try{
			Thread.sleep(time);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
