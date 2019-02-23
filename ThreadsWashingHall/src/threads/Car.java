package threads;

public class Car implements Runnable{
	private WashingHall washingHall;
	private Hall hall;
	
	public Car(WashingHall washingHall) {
		this.washingHall=washingHall;
	}
	public void run() {
		while(true) {
			hall=washingHall.enterForWashing();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			washingHall.leaveWashing(hall);
			washingHall.drive();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
