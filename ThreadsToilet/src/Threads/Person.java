package Threads;

public class Person implements Runnable{
	private PublicToilet toilet;
	
	public Person(PublicToilet toilet) {
		this.toilet=toilet;
	}
	public void run() {
		//while(true) {
			toilet.stepIntoCabin(this);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			toilet.leaveCabin();
			toilet.startWashingHands(this);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			toilet.stopWashingHands();
			toilet.startDryingHands(this);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			toilet.stopDryingHands();
			toilet.drinkLambrusco();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
	}
}
