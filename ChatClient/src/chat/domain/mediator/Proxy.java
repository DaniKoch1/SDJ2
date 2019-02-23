package chat.domain.mediator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.google.gson.Gson;

import chat.domain.model.ChatMessage;

public class Proxy implements ChatModel {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ChatModel model;
	
	public Proxy (ChatModel model, String host, int port)
	{
		this.model=model;
		try {
			socket = new Socket(host, port);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected to server: "+host+" at port "+port);
		ReceiverThreadHandler receiver= new ReceiverThreadHandler(model, in);
		Thread receiverThread= new Thread(receiver);
		receiverThread.start();
	}

	@Override
	public void addMessage(ChatMessage message) {
		try {
			Gson gson =new Gson();
			String json=gson.toJson(message);
			out.writeUTF(json);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		
	}
}
