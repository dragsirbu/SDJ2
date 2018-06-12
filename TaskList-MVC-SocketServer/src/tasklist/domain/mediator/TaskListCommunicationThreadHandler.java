package tasklist.domain.mediator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;

import tasklist.domain.model.Task;

public class TaskListCommunicationThreadHandler implements Runnable
{
   private DataInputStream in;
   private DataOutputStream out;
   private Socket socket;
   private String ip;
   private TaskListModel taskList;

   public TaskListCommunicationThreadHandler(Socket socket,
         TaskListModel taskList)
   {
      this.taskList = taskList;
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
            Package request = gson.fromJson(line, Package.class);
            System.out.println("package: " + request);

            Package reply = operation(request);

            // convert to JSon
            // gson = new Gson();
            String json = gson.toJson(reply);
            out.writeUTF(json);
            System.out.println("Server to " + ip + "> " + reply);
            if (reply.getText().equalsIgnoreCase("EXIT"))
            {
               continueCommuticating = false;
            }
         }
         System.out.println("Closing connection to client: " + ip);
      }
      catch (Exception e)
      {
         String message = e.getMessage();
         if (message == null)
         {
            message = "Connection lost";
         }
         System.out
               .println("Error for client: " + ip + " - Message: " + message);
      }
   }

   private Package operation(Package request)
   {
      switch (request.getText())
      {
         case Package.ADD:
            taskList.add(request.getTask());
            return new Package(Package.ADD);
         case Package.GET:
            Task nextTask = taskList.get();
            if (nextTask == null)
            {
               return new Package("NO TASKS - EMPTY TASKLIST", null);
            }
            return new Package(Package.GET, nextTask);
         case Package.SIZE:
            int size = taskList.size();
            return new Package("SIZE=" + size, null);
         case Package.EXIT:
            return new Package("EXIT", null);
         default:
            return new Package("WRONG FORMAT", null);
      }

   }
}
