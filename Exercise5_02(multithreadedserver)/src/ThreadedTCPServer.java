import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedTCPServer {

	private static ServerSocket listeningSocket;
	private static final int PORT = 3456;
	private static String clientIP;

	public ThreadedTCPServer() {
		try {
			System.out.println("Starting Server...");
			listeningSocket = new ServerSocket(PORT);
			System.out.println("ServerSocket: " + listeningSocket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// Step 1: Creating the server welcoming socket
		System.out.println("Waiting for a client...");
		new ThreadedTCPServer().handleClient();
	}

	private static void handleClient() {
		do {

			Socket connSocket = null;
			try {
				// Step 2: put the server into a waiting state for contact by the client
				connSocket = listeningSocket.accept();
				clientIP = connSocket.getInetAddress().getHostAddress();
				System.out.println("Welcome " + clientIP);
				// Step 3 : setup input and output streams
				Thread client = new Thread(new TCPClientThreadHandler(connSocket));
				client.start();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} while (true);
	}

}
