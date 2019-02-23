
public class ParkingTest {
	public static void main(String[] args) {
		Garage garage=new Garage(4);
		Car c1=new Car(garage);
		Car c2=new Car(garage);
		Car c3=new Car(garage);
		Car c4=new Car(garage);
		Car c5=new Car(garage);
		Car c6=new Car(garage);
		
		Thread t1=new Thread(c1, "Suzuki");
		Thread t2=new Thread(c1, "Toyota");
		Thread t3=new Thread(c1, "Alfa Romeo");
		Thread t4=new Thread(c1, "Ford");
		Thread t5=new Thread(c1, "Chevrolet");
		Thread t6=new Thread(c1, "Fiat 126");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}
