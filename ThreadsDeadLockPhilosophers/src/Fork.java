import java.util.ArrayList;

public class Fork {
	private int id;
	private boolean isTaken;
	private ArrayList<Integer> takenId;
	private int noOfForks;
	
	public Fork(int id, int no) {
		this.id=id;
		isTaken=false;
		takenId=new ArrayList<>();
		noOfForks=no;
	}
	public synchronized void getRightFork() {
		
		while(isTaken || isLeftForkTaken()) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting for the right fork");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" got the right fork");
		isTaken=true;
		takenId.add(id);
		notify();
	}
	public synchronized void getLeftFork() {
		
		while(isTaken) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting for the left fork");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" is eating");
		isTaken=true;
		takenId.add(id);
		notify();
	}
	public synchronized void putBackFork() {
		System.out.println(Thread.currentThread().getName()+" finished eating");
		isTaken=false;
		takenId.remove((Integer)id);
		notify();
	}
	public synchronized boolean isLeftForkTaken() {
		int leftId;
		if(id-1>=0)
			leftId=id-1;
		else
			leftId=noOfForks-1;
		if(takenId.contains(leftId))
			System.out.println(Thread.currentThread().getName()+" the left fork is taken");
		else
			System.out.println(Thread.currentThread().getName()+" the left fork is free");
		return takenId.contains(leftId);
	}
}
