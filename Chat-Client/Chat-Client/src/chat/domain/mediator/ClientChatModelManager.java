package chat.domain.mediator;

import java.io.IOException;
import java.util.Observable;

import chat.domain.model.ChatMessage;

public class ClientChatModelManager extends Observable implements ChatModel
{
   private Proxy proxy;

   public ClientChatModelManager()
   {
      try
      {
         proxy = new Proxy(this, "localhost", 2910);
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   public void addMessage(ChatMessage message)
   {
      if (message.getId().startsWith("BROADCAST"))
      {
         super.setChanged();
         super.notifyObservers(message);
      }
      else
      {
         proxy.addMessage(message);
      }
   }

}
