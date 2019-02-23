import threads.*;

public class main {
	public static void main(String[] args) {
		WashingHall washingHall=new WashingHall(4);
		Car c1=new Car(washingHall);
		Car c2=new Car(washingHall);
		Car c3=new Car(washingHall);
		Car c4=new Car(washingHall);
		Car c5=new Car(washingHall);
		Car c6=new Car(washingHall);
		
		Thread t1=new Thread(c1, "Suzuki");
		Thread t2=new Thread(c2, "Toyota");
		Thread t3=new Thread(c3, "Chevrolet");
		Thread t4=new Thread(c4, "Ford");
		Thread t5=new Thread(c5, "AlfaRomeo");
		Thread t6=new Thread(c6, "Ferrari");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}
