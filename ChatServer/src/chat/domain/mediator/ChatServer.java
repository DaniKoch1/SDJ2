package chat.domain.mediator;
import java.io.IOException;
import java.net.*;


public class ChatServer implements Runnable {

	private ServerSocket welcomeSocket;
	private ChatModel model;
	
	public ChatServer (ChatModel model, int port)
	{
			try {
				welcomeSocket = new ServerSocket(port);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.model = model;
			System.out.println("Starting server...");
	}
	
	public void run()
	{
		while (true)
		{
			System.out.println("Waiting for a client...");
			try {
				Socket connSocket = welcomeSocket.accept();
				Thread thread = new Thread(new ChatCommunicationThreadHandler(connSocket, model));
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
