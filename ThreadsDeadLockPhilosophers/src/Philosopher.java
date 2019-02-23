
public class Philosopher implements Runnable{
	private int id;
	private Fork leftFork, rightFork;
	
	public Philosopher(int id, Fork leftFork, Fork rightFork) {
		this.id=id;
		this.leftFork=leftFork;
		this.rightFork=rightFork;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			rightFork.getRightFork();
			leftFork.getLeftFork();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			rightFork.putBackFork();
			leftFork.putBackFork();
		}
	}
}
