package tasklist.domain.mediator;
import java.io.*;
import java.net.*;

import com.google.gson.Gson;

public class TaskListCommunicationThreadHandler implements Runnable {

	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	private String ip;
	private TaskListModel taskList;

	public TaskListCommunicationThreadHandler(Socket socket, TaskListModel taskList) {
		this.socket = socket;
		this.ip = socket.getInetAddress().getHostAddress();
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("sbvdjns");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.taskList = taskList;
	}

	public void run() {
		String fromClientMessage, toClientMessage;
		Package fromClientPackage, toClientPackage;
		Gson gson;
		while (true) {
			try {
				fromClientMessage = in.readUTF();
				System.out.println("Client> " + fromClientMessage);
				gson = new Gson();
				fromClientPackage = gson.fromJson(fromClientMessage, Package.class);
				System.out.println("Package: " + fromClientPackage.getText());
				gson = new Gson();
				toClientPackage = operation(fromClientPackage);
				toClientMessage = gson.toJson(toClientPackage);
				System.out.println("Server> " + toClientPackage);
				out.writeUTF(toClientMessage);
				if (fromClientPackage.getText().equals("EXIT")) {
					break;
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Closing connection with client:"+ip);
	}

	private Package operation(Package fromClient) {
		Package reply;
		switch (fromClient.getText()) {
		case "ADD":
			taskList.add(fromClient.getTask());
			reply = new Package(Package.ADD);
			break;
		case "GET":
			if (taskList.size() > 0) {
				reply = new Package(Package.GET, taskList.get());
			} else {
				reply = new Package("NO TASKS - EMPTY TASK LIST");
			}
			break;
		case "SIZE":
			reply = new Package("" + taskList.size());
			break;
		case "EXIT":
			reply = new Package(Package.EXIT);
			break;
		default:
			reply = new Package("WRONG FORMAT");
			break;
		}
		return reply;
	}
}
