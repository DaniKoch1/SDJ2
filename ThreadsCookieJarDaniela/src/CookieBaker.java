
public class CookieBaker implements Runnable{

	private CookieJar jar;
	
	public CookieBaker(CookieJar jar)
	{
		this.jar=jar;
	}
	public synchronized void run() {
		while(true) {
			jar.startBaking();
			try {
				Thread.sleep(6000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			jar.finishedBaking();
		}
	}

}
