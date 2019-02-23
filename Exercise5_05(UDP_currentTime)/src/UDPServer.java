import java.io.IOException;
import java.net.*;
import java.util.GregorianCalendar;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		final int PORT=1998;
		System.out.println("The server is starting...");
		
		DatagramSocket serverSocket = new DatagramSocket(PORT);
		while(true)
		{
			byte[] receiveData=new byte[1024];
			DatagramPacket receivePacket=new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String msg=new String(receivePacket.getData()).trim();
			
			InetAddress IP=receivePacket.getAddress();
			int port=receivePacket.getPort();
			long sendData;
			
			if(msg.toLowerCase().equals("time"))
			{
				sendData=GregorianCalendar.getInstance().getTimeInMillis();
			}
			else
			{
				//sendData=-1;
			}
			DatagramPacket sendPacket=new DatagramPacket(sendData, 0, IP, port);
			
			serverSocket.send(sendPacket);
		}
	}
}
