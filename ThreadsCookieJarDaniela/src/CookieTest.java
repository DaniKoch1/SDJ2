
public class CookieTest {
	public static void main(String[] args) {
		CookieJar jar=new CookieJar(5);
		CookieBaker koch=new CookieBaker(jar);
		CookieEater dani=new CookieEater(jar);
		CookieEater miska=new CookieEater(jar);
		CookieEater reme=new CookieEater(jar);
		
		Thread t1=new Thread(koch, "Der Koch");
		Thread t2=new Thread(dani, "Dani");
		Thread t3=new Thread(miska, "Miœka");
		Thread t4=new Thread(reme, "Reme");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
