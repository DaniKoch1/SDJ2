import java.io.IOException;
import java.net.*;

public class ChatServer {
	private ServerSocket welcomeSocket;
	
	public ChatServer(int port) throws IOException
	{
		welcomeSocket=new ServerSocket(port);
	}
	public void execute() throws IOException
	{
		while(true)
		{
			Socket client=welcomeSocket.accept();
			Thread thread=new Thread(new CommunicationThreadHandler(client));
			thread.start();
		}
	}
}
