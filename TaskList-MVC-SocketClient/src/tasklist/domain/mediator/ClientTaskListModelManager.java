package tasklist.domain.mediator;

import java.io.IOException;

import tasklist.domain.model.Task;

public class ClientTaskListModelManager implements TaskListModel
{
   private TaskListModel client;

   public ClientTaskListModelManager()
   {
      try
      {
         this.client = new TaskListClient("localhost", 6789);
         System.out.println("Connected...");
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   @Override
   public void add(Task task)
   {
      client.add(task);
   }

   @Override
   public Task get()
   {
      return client.get();
   }

   @Override
   public int size()
   {
      return client.size();
   }

}
