import java.io.*;
import java.net.*;

public class TCPServer {
	private static ServerSocket welcomingSocket;
	private static final int PORT = 3456;
	private static String clientIP;

	public static void main(String[] args) {
		System.out.println("Starting Server...");
		// Step 1: Creating the server welcoming socket
			try {
				welcomingSocket = new ServerSocket(PORT);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Waiting for a client...");
			handleClient();
			System.exit(1);
	}

	private static void handleClient() {
		Socket connSocket = null;
		try {
			// Step 2: put the server into a waiting state for contact by the client
			connSocket = welcomingSocket.accept();
			clientIP = connSocket.getInetAddress().getHostAddress();
			System.out.println("Welcome " + clientIP);
			// Step 3 : setup input and output streams
			DataInputStream inFromClient = new DataInputStream(connSocket.getInputStream());
			DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());
			// Step 4: Send and receive data
			
			String message = inFromClient.readUTF();
			if (message.equals("hello")) {
				System.out.println("Received Message. OK!");
				outToClient.writeUTF("name?");
			}
			else
			{
				System.out.println("Wrong fotantnf");
			}
			try {
				System.out.println("\n Now closing connection...");
				// Step 5: Close the connection
				connSocket.close();
			} catch (IOException e) {
				System.out.println("Unable to close the connection!");
				System.exit(1);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
