package tasklist.view;

import java.util.Scanner;
import tasklist.controller.TaskListController;

public class TaskListConsole implements TaskListView, Runnable{
	private TaskListController controller;
	private Scanner in;
	
	public TaskListConsole()
	{
		in=new Scanner(System.in);
		controller=null;
	}
	public void startView(TaskListController controller)
	{
		this.controller=controller;
		Thread thread=new Thread(this);
		thread.start();
	}
	public void run()
	{
		int choice;
		System.out.print("1) Type 1 for \"ADD\"\n" + "2) Type 2 to \"GET\""
	               + "\n3) Type 3 to get the \"SIZE\"\n"
	               + "0) Type 0 to \"EXIT\"\nEnter choice: ");
	    choice = in.nextInt();
	    in.nextLine();
		while(choice!=0)
		{
			controller.execute(choice);
			System.out.print("1) Type 1 for \"ADD\"\n" + "2) Type 2 to \"GET\""
		               + "\n3) Type 3 to get the \"SIZE\"\n"
		               + "0) Type 0 to \"EXIT\"\nEnter choice: ");
		    choice = in.nextInt();
		    in.nextLine();
		}
		in.close();
	}
	public String get(String what)
	{
        System.out.print("Enter " + what + ": ");
        what=in.nextLine();
        return what;
	}
	public void show(String sth)
	{
		System.out.println(sth);
	}
}
