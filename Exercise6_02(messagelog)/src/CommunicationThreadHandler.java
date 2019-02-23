import java.io.*;
import java.net.*;

import com.google.gson.Gson;

public class CommunicationThreadHandler implements Runnable{
	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	private String ip;
	private LogList loglist;
	
	public CommunicationThreadHandler(Socket socket, LogList loglist) throws IOException
	{
		this.socket=socket;
		in=new DataInputStream(socket.getInputStream());
		out=new DataOutputStream(socket.getOutputStream());
		ip= socket.getInetAddress().getHostAddress();
		this.loglist = loglist;
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
			Log log = new Log(ip, msg);
			loglist.add(log);
			System.out.println(loglist);
			if(msg.getBody().equals("exit"))
			{
				
				break;
			}
		}
	}
}
