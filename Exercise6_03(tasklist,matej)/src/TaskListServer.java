import java.io.IOException;
import java.net.*;

public class TaskListServer {

	private ServerSocket welcomeSocket;
	private TaskList taskList;
	
	public TaskListServer (TaskList taskList, int port)
	{
			try {
				welcomeSocket = new ServerSocket(port);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.taskList = taskList;		
	}
	
	public void execute()
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
