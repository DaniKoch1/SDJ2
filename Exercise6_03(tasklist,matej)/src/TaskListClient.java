import java.io.*;
import java.net.*;
import java.util.Scanner;

import com.google.gson.Gson;

public class TaskListClient {

	private Scanner input;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	public TaskListClient (String host, int port)
	{
		input = new Scanner(System.in);
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
	
	public void execute()
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
			Gson gson = new Gson();
			toServerMessage = gson.toJson(toServerPackage);
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
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void close()
	{
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input.close();
		System.out.println("Closing the connection...");
	}
}
