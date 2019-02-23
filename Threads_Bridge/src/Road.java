
public class Road {
	public static void main(String[] args) {
		Bridge bridge=new Bridge();
		Thread[] redCars = new Thread[18];
		Thread[] blueCars = new Thread[15];
		for (int i=0; i<15; i++)
		{
			BlueCar blueCar = new BlueCar(bridge);
			blueCars[i] = new Thread(blueCar, "Blue car"+ i);
			blueCars[i].start();
		}
		for (int i=0; i<18; i++)
		{
			RedCar redCar = new RedCar(bridge);
			redCars[i] = new Thread(redCar, "Red car"+ i);
			redCars[i].start();
		}
	}
}
