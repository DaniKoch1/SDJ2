package tasklist.domain.mediator;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import com.google.gson.Gson;

import tasklist.domain.model.Task;

public class TaskListClient implements TaskListModel {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	public TaskListClient (String host, int port)
	{
		try {
			socket = new Socket(host, port);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected to server: "+host+" at port "+port);
	}
	
	private Package remoteCall(Package request)
	{
		String taskText, toServerMessage, fromServerMessage;
		Package toServerPackage, fromServerPackage=null;
		Gson gson = new Gson();
		toServerMessage = gson.toJson(request);
		System.out.println("Client> "+toServerMessage);
		try {
			out.writeUTF(toServerMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Waiting for response...");
		
		try {
			fromServerMessage = in.readUTF();
			gson = new Gson();
			fromServerPackage = gson.fromJson(fromServerMessage, Package.class);
			System.out.println("Server> "+fromServerMessage);
			System.out.println("Task: "+fromServerPackage.getText());
			if(fromServerPackage.getText().equals("EXIT"))
			{
				close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fromServerPackage;
	}
	
	/*public void execute()
	{
		while (true)
		{
			String taskText, toServerMessage, fromServerMessage;
			int estimatedTime;
			Package toServerPackage, fromServerPackage;
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
				Task task = new Task(taskText, estimatedTime);
				toServerPackage = new Package(Package.ADD, task);
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
	}*/
	
	public void close()
	{
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Closing the connection...");
	}

	@Override
	public void add(Task task) {
		Package request = new Package(Package.ADD, task);
		remoteCall(request);
	}

	@Override
	public Task get() {
		Package request = new Package(Package.GET);
		
		remoteCall(request);
		return request.getTask();
	}

	@Override
	public int size() {
		Package request = new Package(Package.SIZE);
		//remoteCall(request);
		return Integer.parseInt(remoteCall(request).getText());
		
		/*remoteCall(new Package(Package.SIZE));
		//return Integer.parseInt(request.SIZE);
		return (int) Integer.parseInt(Package.SIZE);*/

	}
}
