import java.io.*;
import java.net.*;

import com.google.gson.Gson;

public class CommunicationThreadHandler implements Runnable{
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	private String ip;
	
	public CommunicationThreadHandler(Socket socket) throws IOException
	{
		this.socket=socket;
		in=new DataInputStream(socket.getInputStream());
		out=new DataOutputStream(socket.getOutputStream());
		ip= socket.getInetAddress().getHostAddress();
	}
	public void run()
	{
		Message msg;
		Gson gson = new Gson();
		while(true) {
			String message="";
			try {
				message = in.readUTF();
			} catch (IOException e) {}
			msg=gson.fromJson(message, Message.class);
			System.out.println(msg);
			if(msg.getBody().equals("exit"))
			{
				
				break;
			}
		}
	}
}
