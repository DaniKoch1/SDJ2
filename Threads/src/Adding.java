import java.util.Scanner;

import utility.collection.ArrayQueue;

public class Adding implements Runnable {
	
	private ArrayQueue<String> list;
	private String id;
	private long sleepTime;
	
	public Adding(ArrayQueue<String> list, String id, long sleepTime) {
		this.list = list;
		this.id = id;
		this.sleepTime = sleepTime;
	}
	
	public void run()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Input 5 strings");
		for (int i = 0;i<5;i++)
			list.enqueue(in.nextLine());
		int number=1;
		String print;
		while (true)
		{
			try {
				print=number+"; ";
				number++;
				print+=id+"; ";
				print+=list;
				Thread.sleep(sleepTime);
				System.out.println(print);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
