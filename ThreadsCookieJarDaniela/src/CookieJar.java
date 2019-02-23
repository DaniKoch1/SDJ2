
public class CookieJar {
	private int noOfCookies;
	private int minNoOfCookies;
	
	public CookieJar(int number) {
		noOfCookies=0;
		minNoOfCookies=number;
	}
	public synchronized void startBaking() {
		while(noOfCookies>=minNoOfCookies) {
			try {
				//System.out.println(noOfCookies+" cookies left.");
				wait();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Cookies are starting to be baked.");
	}
	public synchronized void finishedBaking() {
		System.out.println(Thread.currentThread().getName()+ " hat 16 Plätzchen gebackt.");
		notifyAll();
		noOfCookies+=16;
	}
	public synchronized void eat() {
		while(noOfCookies<1) {
			try {
				System.out.println(Thread.currentThread().getName()+": There are no cookies in the jar!!!");
				wait();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		noOfCookies--;
		System.out.println(Thread.currentThread().getName()+" has eaten a cookie; "+noOfCookies+" cookies left.");
	}
	public int getNoOfCookies() {
		return noOfCookies;
	}
}
