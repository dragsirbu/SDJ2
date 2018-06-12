package tasklist.domain.mediator;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import com.google.gson.Gson;

import tasklist.domain.model.Task;

public class TaskListClient implements TaskListModel
{
   private DataInputStream in;
   private DataOutputStream out;
   private Socket socket;

   public TaskListClient(String host, int port)
         throws UnknownHostException, IOException
   {
      // create client socket, connect to server.
      socket = new Socket(host, port);
      System.out.println("Connected to server: " + host + " at port " + port);

      // create input stream attached to the socket.
      in = new DataInputStream(socket.getInputStream());

      // create output stream attached to the socket.
      out = new DataOutputStream(socket.getOutputStream());
   }

   private Package remoteCall(Package request)
   {
      try
      {
         // convert to JSon
         Gson gson = new Gson();
         String json = gson.toJson(request);

         System.out.println("Client> " + json);
         out.writeUTF(json);
         // Read reply from Server.
         String reply = in.readUTF();
         System.out.println("Server> " + reply);

         // convert from JSon
         gson = new Gson();
         Package replyPackage = gson.fromJson(reply, Package.class);
         System.out.println("Task: " + replyPackage);
         return replyPackage;
      }
      catch (IOException e)
      {
         e.printStackTrace();
         return null;
      }
   }

   @Override
   public void add(Task task)
   {
      Package request = new Package(Package.ADD, task);
      Package reply = remoteCall(request); // waiting for a reply
   }

   @Override
   public Task get()
   {
      Package request = new Package(Package.GET);
      Package reply = remoteCall(request);
      return reply.getTask();
   }

   @Override
   public int size()
   {
      Package request = new Package(Package.SIZE);
      Package reply = remoteCall(request);
      int size = -1;
      try
      {
         size = Integer.parseInt(reply.getText().substring(5));
      }
      catch (Exception e)
      {
         //
      }
      return size;
   }
}
