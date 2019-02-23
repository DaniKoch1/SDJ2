
public class Bridge implements Lane{

	private int goingLeft;
	private int goingRight;
	private int waitingLeft;
	
	public Bridge() {
		goingRight=0;
		goingLeft=0;
	}
	public synchronized void enterFromTheLeft() {
		waitingLeft++;
		notify();
		while(goingRight>0) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting\n"+goingRight+" cars from the right.");
				System.out.println(waitingLeft+" cars are waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		goingLeft++;
		waitingLeft--;
		notify();
		System.out.println(Thread.currentThread().getName()+" is going.");
	}
	public synchronized void exitToTheRight() {
		goingLeft--;
		System.out.println(Thread.currentThread().getName()+" has gone.\n"+goingLeft+" more cars going from the left.");
		notify();	
	}
	public synchronized void enterFromTheRight() {
		while(goingLeft>0 || waitingLeft>4) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting\n"+goingLeft+" cars from the left.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		goingRight++;
		System.out.println(Thread.currentThread().getName()+" is going.");
	}
	public synchronized void exitToTheLeft() {
		goingRight--;
		System.out.println(Thread.currentThread().getName()+" has gone.\n"+goingRight+" more cars going from the right.");
		notify();
	}

}
