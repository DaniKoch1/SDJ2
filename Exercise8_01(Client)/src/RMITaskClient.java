import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import javafx.concurrent.Task;

public class RMITaskClient {

	private RemoteTaskList list;
	
	public RMITaskClient () throws MalformedURLException, RemoteException, NotBoundException
	{
		start();
	}
	
	public void start() throws MalformedURLException, RemoteException, NotBoundException {
		list=(RemoteTaskList) Naming.lookup("rmi://localhost:1099/server");
		Scanner input=new Scanner(System.in);
		String taskText, toServerMessage, fromServerMessage;
		int estimatedTime;
		while (true)
		{
			System.out.println("Type 1 for 'ADD'");
			System.out.println("Type 2 to 'GET'");
			System.out.println("Type 3 to get the 'SIZE'");
			System.out.println("Type 0 to 'EXIT'");
			System.out.println("Enter choice:");
			int choice = Integer.parseInt(input.nextLine());
			System.out.println("");
			switch (choice)
			{
			case 1:
				System.out.println("Enter task:");
				taskText = input.nextLine();
				System.out.println("Enter estimated time");
				estimatedTime = Integer.parseInt(input.nextLine());
				list.add(new Task(taskText,estimatedTime));
				break;
			case 2:
				toServerPackage = new Package(Package.GET);
				break;
			case 3:
				toServerPackage = new Package(Package.SIZE);
				break;
			case 0:
				toServerPackage = new Package(Package.EXIT);
				break;
			default:
				System.out.println("Wrong input, try again");
				continue;
			}
		}
	}
}
