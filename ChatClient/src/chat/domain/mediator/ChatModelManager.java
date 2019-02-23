package chat.domain.mediator;

import java.util.Observable;

import chat.domain.model.ChatMessage;

public class ChatModelManager extends Observable implements ChatModel
{
   private Proxy proxy;
 
   public ChatModelManager()
   {
      proxy=new Proxy(this, "localhost", 2412);
   }

   @Override
   public void addMessage(ChatMessage message)
   {
	   if(message.getId().equals("BROADCAST"))
	   {
	      super.setChanged();
	      notifyObservers(message);
	   }
	   else
	   {
		   proxy.add(message);
	   }
   }

}
