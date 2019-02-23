
public class BlueCar implements Runnable{
	private Lane bridge;
	
	public BlueCar(Bridge bridge) {
		this.bridge=bridge;
	}
	public void run() {
		while(true) {
		bridge.enterFromTheRight();
		going(1500, 5000);
		bridge.exitToTheLeft();
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
