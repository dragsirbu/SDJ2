
import chat.controller.ChatController;
import chat.domain.mediator.ChatModel;
import chat.domain.mediator.ClientChatModelManager;
import chat.view.ClientChatGui;
import chat.view.ChatView;

public class ClientMain
{
   public static void main(String args[])
   {
      try
      {
         ChatModel model = new ClientChatModelManager();
         ChatView view = new ClientChatGui();
         ChatController controller = new ChatController(model, view);

         view.start(controller);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
