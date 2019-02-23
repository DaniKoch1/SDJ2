package chat.domain.mediator;

import java.io.DataInputStream;
import java.io.IOException;

import chat.domain.model.ChatMessage;

public class ReceiverThreadHandler implements Runnable{
	
	private ChatModel model;
	private DataInputStream in;
	
	public ReceiverThreadHandler(ChatModel model, DataInputStream in) {
		this.model=model;
		this.in=in;
	}

	@Override
	public void run() {
		while(true)
		{
			String fromClientMessage, toClientMessage;
			ChatMessage fromClientPackage, toClientPackage;
			Gson gson;
			
				try {
					fromClientMessage = in.readUTF();		
					gson = new Gson();
					fromClientPackage = gson.fromJson(fromClientMessage, ChatMessage.class);
					toClientMessage.setId("BROADCAST");
					model.addMessage(toClientPackage);
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		
	}

}
