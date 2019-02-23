
public class Camper implements Runnable{
	private CampsitePancakeCooking campsite;
	
	public Camper(CampsitePancakeCooking campsite) {
		this.campsite=campsite;
	}
	public void run() {
		int counter=0;
		while(counter<8) {
			campsite.takeBakingPlate();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			campsite.pourBatterOnBakingPlate();
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			campsite.makeAPancake();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			campsite.putBackBakingPlate();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			campsite.eatAPancake();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++;
		}
	}
}
