
public class Garage implements ParkingPlace{
	private int freeSpaces;
	
	public Garage(int totalPlaces) {
		freeSpaces=totalPlaces;
	}
	public synchronized void arrive() {
		while(freeSpaces<1) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting for a free place.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" has parked.");
		notifyAll();
		freeSpaces--;
	}
	public synchronized void leave() {
		System.out.println(Thread.currentThread().getName()+" is leaving.");
		notifyAll();
		freeSpaces++;
	}
	public synchronized int freePlaces() {
		return freeSpaces;
	}
	public synchronized void drive() {
		System.out.println(Thread.currentThread().getName()+" is driving.");
	}
}
