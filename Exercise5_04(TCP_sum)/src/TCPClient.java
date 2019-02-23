import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
	private static InetAddress host;
	private static final int PORT=1998;
	
	public static void main(String[] args) {
		try {
			host=InetAddress.getLocalHost();
		}
		catch(UnknownHostException e)
		{	}
		accessServer();
	}
	private static void accessServer() {
		Socket clientSocket=null;
		try {
			clientSocket=new Socket(host, PORT);
			DataInputStream dis=new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dos=new DataOutputStream(clientSocket.getOutputStream());
			Scanner in=new Scanner(System.in);
			int a, b, resp;
			System.out.println("Input two integers: ");
			a=in.nextInt();
			b=in.nextInt();
			
			dos.writeInt(a);
			dos.writeInt(b);
			resp = dis.readInt();
			System.out.println("From server: "+resp);
		}
		catch(IOException e)
		{	}
		finally
		{
			try
			{
				System.out.println("Closing the connection...");
				clientSocket.close();
			}
			catch(IOException e) {}
		}
		
	}
}
