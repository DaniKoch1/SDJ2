package tasklist.domain.mediator;
import java.io.IOException;
import java.net.*;

import tasklist.domain.model.TaskList;

public class TaskListServer implements Runnable {

	private ServerSocket welcomeSocket;
	private TaskListModel taskList;
	
	public TaskListServer (TaskListModel taskList, int port)
	{
			try {
				welcomeSocket = new ServerSocket(port);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.taskList = taskList;		
	}
	
	public void run()
	{
		System.out.println("Waiting for a client...");
		while (true)
		{
			try {
				Socket connSocket = welcomeSocket.accept();
				Thread thread = new Thread(new TaskListCommunicationThreadHandler(connSocket, taskList));
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
