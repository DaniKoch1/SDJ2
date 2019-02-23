package chat.domain.mediator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import com.google.gson.Gson;

import chat.domain.model.ChatMessage;

public class ChatCommunicationThreadHandler implements Runnable, Observer {

	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	private String ip;
	private ChatModel model;

	public ChatCommunicationThreadHandler(Socket socket, ChatModel model) {
		this.socket = socket;
		this.ip = socket.getInetAddress().getHostAddress();
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("sbvdjns");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.model = model;
		Observable obs= (Observable) model;
		obs.addObserver(this);
	}

	public void run() {
		String fromClientMessage, toClientMessage;
		ChatMessage fromClientPackage, toClientPackage;
		Gson gson;
		while (true) {
			try {
				fromClientMessage = in.readUTF();
				System.out.println("Client> " + fromClientMessage);
				
				gson = new Gson();
				fromClientPackage = gson.fromJson(fromClientMessage, ChatMessage.class);
				System.out.println("Message: " + fromClientPackage);
				model.addMessage(fromClientPackage);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Closing connection with client:"+ip);
	}

	private Package operation(Package fromClient) {
		Package reply;
		switch (fromClient.getText()) {
		case "ADD":
			model.add(fromClient.getTask());
			reply = new Package(Package.ADD);
			break;
		case "GET":
			if (model.size() > 0) {
				reply = new Package(Package.GET, model.get());
			} else {
				reply = new Package("NO TASKS - EMPTY TASK LIST");
			}
			break;
		case "SIZE":
			reply = new Package("" + model.size());
			break;
		case "EXIT":
			reply = new Package(Package.EXIT);
			break;
		default:
			reply = new Package("WRONG FORMAT");
			break;
		}
		return reply;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		try {
		Gson gson =new Gson();
		String json=gson.toJson((ChatMessage)arg1);
		out.writeUTF(json);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
