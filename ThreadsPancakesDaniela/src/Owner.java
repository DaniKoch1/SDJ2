
public class Owner implements Runnable{

	private CampsitePancakeCooking campside;
	
	public Owner(CampsitePancakeCooking campside) {
		this.campside=campside;
	}
	public void run() {
		while(true) {
			campside.mixABowlOfPancakeBatter();
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			campside.refillBowl(campside.getMaxBatter()-campside.getBatterLeft());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
