package chat.domain.mediator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import com.google.gson.Gson;

import chat.domain.model.ChatMessage;

public class ChatCommunicationThreadHandler implements Runnable, Observer
{
   private DataInputStream in;
   private DataOutputStream out;
   private Socket socket;
   private String ip;
   private ChatModel model;

   public ChatCommunicationThreadHandler(Socket socket,
         ChatModel model)
   {
      this.model = model;
      Observable obs = (Observable)model;
      obs.addObserver(this);
      try
      {
         this.socket = socket;
         in = new DataInputStream(socket.getInputStream());
         out = new DataOutputStream(socket.getOutputStream());
         this.ip = socket.getInetAddress().getHostAddress();
         System.out.println(ip + " connected");
      }
      catch (IOException e)
      {
         System.out.println(
               "Error for client connection. Message: " + e.getMessage());
      }
   }

   @Override
   public void run()
   {
      boolean continueCommuticating = true;
      try
      {
         while (continueCommuticating)
         {
            String line = in.readUTF();
            System.out.println(ip + "> " + line);

            // convert from JSon
            Gson gson = new Gson();
            ChatMessage message = gson.fromJson(line, ChatMessage.class);
            model.addMessage(message);
         }
         System.out.println("Closing connection to client: " + ip);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Override
   public void update(Observable o, Object arg)
   {
      try
      {
         // convert to JSon
         Gson gson = new Gson();
         String json = gson.toJson((ChatMessage)arg);
         out.writeUTF(json);
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } 
   }
}
