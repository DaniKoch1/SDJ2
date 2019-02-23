import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		final int PORT=1998;
		final String HOST="localhost";
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket clientSocket=new DatagramSocket();
		
		InetAddress IP= InetAddress.getLocalHost();
		byte[] sendData=new byte[1024];
		byte[] receiveData=new byte[1024];
		
		System.out.println("What do you want from the server?");
		String msg=in.readLine();
		sendData=msg.getBytes();
		
		DatagramPacket sendPacket=new DatagramPacket(sendData, sendData.length, IP, PORT);
		
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
		
		clientSocket.receive(receivePacket);
		String modifiedStc= new String(receivePacket.getData()).trim();
		System.out.println("Server replied: "+modifiedStc);
		
		clientSocket.close();
	}
}
