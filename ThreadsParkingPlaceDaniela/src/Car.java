
public class Car implements Runnable{
	private Garage parking;
	
	public Car(Garage parking) {
		this.parking=parking;
	}
	public void run() {
		while(true) {
			parking.drive();
			
			try {
				Thread.sleep((long)Math.random()*8000+3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			parking.arrive();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parking.leave();
		}
		
	}
	
	
}
