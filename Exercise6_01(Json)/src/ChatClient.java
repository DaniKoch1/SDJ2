import java.io.*;
import java.net.*;
import java.util.Scanner;
import com.google.gson.Gson;

public class ChatClient {
	private Scanner input;
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	
	public ChatClient(String host, int port) throws UnknownHostException, IOException
	{
		input=new Scanner(System.in);
		socket=new Socket(host, port);
		in=new DataInputStream(socket.getInputStream());
		out=new DataOutputStream(socket.getOutputStream());
	}
	public void execute() throws IOException
	{
		String msg="", json;
		Gson gson=new Gson();
		while(true)
		{
			msg=input.nextLine();
			Message message=new Message(msg);
			json=gson.toJson(message);
			out.writeUTF(json);
			if(msg.equals("exit"))
			{
				close();
				break;
			}
		}
	}
	public void close() throws IOException
	{
		socket.close();
		input.close();
	}
}
