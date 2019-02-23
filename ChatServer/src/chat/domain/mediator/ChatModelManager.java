package chat.domain.mediator;

import java.util.Observable;

import chat.domain.model.ChatMessage;
import chat.domain.model.MessageList;

public class ChatModelManager extends Observable implements ChatModel
{
   private MessageList list;
   private ChatServer server;
 
   public ChatModelManager()
   {
      list = new MessageList();
      server= new ChatServer(this, 2412);
      Thread serverThread= new Thread(server);
      serverThread.start();
   }

   @Override
   public void addMessage(ChatMessage message)
   {
      list.add(message);
      super.setChanged();
      notifyObservers(message);
   }

}
