import java.io.*;
import java.net.*;

public class TCPServer {
	private static ServerSocket socket;
	private static final int PORT= 1998;
	private static String clientIP;
	
	public static void main(String[] args) {
		System.out.println("The server is starting...");
		try
		{
			socket=new ServerSocket(PORT);
		}
		catch(IOException e) {}
		handleClient();
	}
	private static void handleClient()
	{
		Socket connSocket=null;
		try
		{
			connSocket=socket.accept();
			clientIP=connSocket.getInetAddress().getHostAddress();
			System.out.println("Welcome "+clientIP);
			
			DataInputStream dis=new DataInputStream(connSocket.getInputStream());
			DataOutputStream dos=new DataOutputStream(connSocket.getOutputStream());
			
			int a,b,sum;
			a=dis.readInt();
			b=dis.readInt();
			sum=a+b;
			dos.writeInt(sum);
		}
		catch(IOException e) {}
		
		finally
		{
			try
			{
			System.out.println("Closing connection...");
			connSocket.close();
			}
			catch(IOException e) {}
		}
	}
}
