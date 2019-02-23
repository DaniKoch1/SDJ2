import Threads.*;

public class test {
	public static void main(String[] args) {
		PublicToilet toilet=new ToiletBuilding(5,2,1);
		Person p1=new Person(toilet);
		Person p2=new Person(toilet);
		Person p3=new Person(toilet);
		Person p4=new Person(toilet);
		Person p5=new Person(toilet);
		Person p6=new Person(toilet);
		Person p7=new Person(toilet);
		Person p8=new Person(toilet);
		Person p9=new Person(toilet);
		Person p10=new Person(toilet);
		Person p11=new Person(toilet);
		Person p12=new Person(toilet);
		
		Thread t1=new Thread(p1, "Dani");
		Thread t2=new Thread(p2, "Miœka");
		Thread t3=new Thread(p3, "Reme");
		Thread t4=new Thread(p4, "Gosia");
		Thread t5=new Thread(p5, "Monia");
		Thread t6=new Thread(p6, "Ola");
		Thread t7=new Thread(p7, "Vili");
		Thread t8=new Thread(p8, "Emilka");
		Thread t9=new Thread(p9, "Lorena");
		Thread t10=new Thread(p10, "Hania");
		Thread t11=new Thread(p11, "Magda");
		Thread t12=new Thread(p12, "Daria");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
	}
}
