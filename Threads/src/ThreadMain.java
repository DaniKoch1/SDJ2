import utility.collection.ArrayQueue;

public class ThreadMain {
	public static void main(String[] args) {
		ArrayQueue<String> q=new ArrayQueue<>();
		Adding adding=new Adding(q, "Yes", 3500);
		Adding adding2=new Adding(q, "No", 2500);
		Adding adding3=new Adding(q, "Maybe", 3000);
		Thread thread=new Thread(adding);
		thread.start();
		Thread thread2=new Thread(adding2);
		thread2.start();
		Thread thread3=new Thread(adding3);
		thread3.start();
	}
}
