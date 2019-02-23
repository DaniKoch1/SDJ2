
public class PancakeTest {
	public static void main(String[] args) {
		CampsitePancakeCooking campsite=new CampsitePancakeCooking(4, 15, 3);
		Owner owner=new Owner(campsite);
		Camper c1=new Camper(campsite);
		Camper c2=new Camper(campsite);
		Camper c3=new Camper(campsite);
		Camper c4=new Camper(campsite);
		Camper c5=new Camper(campsite);
		Camper c6=new Camper(campsite);
		Camper c7=new Camper(campsite);
		Camper c8=new Camper(campsite);
		
		Thread t1=new Thread(owner, "owner");
		Thread t2=new Thread(c1, "Dani");
		Thread t3=new Thread(c2, "Miœka");
		Thread t4=new Thread(c3, "Reme");
		Thread t5=new Thread(c4, "Ola");
		Thread t6=new Thread(c5, "Monia");
		Thread t7=new Thread(c6, "Gosia");
		Thread t8=new Thread(c7, "Vili");
		Thread t9=new Thread(c8, "Marti");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		
		
	}
}
