package tasklist.domain.mediator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer implements Runnable
{
   private TaskListModel taskList;
   private ServerSocket welcomeSocket;

   public TaskListServer(TaskListModel taskList, int port) throws IOException
   {
      this.taskList = taskList;
      this.welcomeSocket = new ServerSocket(port);
      System.out.println("Starting Server at port " + port + "...");
   }

   @Override
   public void run()
   {
      while (true)
      {
         System.out.println("Waiting for a client...");
         try
         {
            Socket socket = welcomeSocket.accept();
            TaskListCommunicationThreadHandler c;
            c = new TaskListCommunicationThreadHandler(socket, taskList);
            Thread t = new Thread(c);
            t.start();
         }
         catch (IOException e)
         {
            System.out.println("Error in server. Message: " + e.getMessage());
         }
      }
   }
}
