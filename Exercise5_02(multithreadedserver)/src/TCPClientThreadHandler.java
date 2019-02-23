import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TCPClientThreadHandler implements Runnable {


	private Socket socket;
	private DataInputStream inFromClient;
	private DataOutputStream outToClient;
	
	
	public TCPClientThreadHandler(Socket socket) {
		this.socket = socket;
		}
	
	public synchronized void run() {
		try {
			inFromClient = new DataInputStream(socket.getInputStream());
			outToClient = new DataOutputStream(socket.getOutputStream());
			
			int msgCount = 0;
			// Step 4: Send and receive data
			String message = inFromClient.readUTF();
			while (!message.equals("Exit")) {
				System.out.println("Received Message. OK!");
				msgCount++;
				outToClient.writeUTF("Message number " + msgCount + ": " + message);
				message = inFromClient.readUTF();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\n Now closing connection...");
			// Step 5: Close the connection
			socket.close();
		} catch (IOException e) {
			System.out.println("Unable to close the connection!");
			System.exit(1);
		}
	}
}
