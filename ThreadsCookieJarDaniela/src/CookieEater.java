
public class CookieEater implements Runnable {

	private CookieJar jar;
	
	public CookieEater(CookieJar jar) {
		this.jar=jar;
	}
	public void run() {
		while(true) {
				jar.eat();
				try {
					Thread.sleep(2000);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			
		}
	}

}
