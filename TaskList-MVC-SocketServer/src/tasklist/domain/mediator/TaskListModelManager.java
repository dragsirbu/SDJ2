package tasklist.domain.mediator;

import java.io.IOException;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;

public class TaskListModelManager implements TaskListModel
{
   private TaskList taskList;
   private TaskListServer server;

   public TaskListModelManager()
   {
      this.taskList = new TaskList();
      try
      {
         this.server = new TaskListServer(this, 6789);
         Thread t = new Thread(this.server);
         t.start();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   @Override
   public synchronized void add(Task task)
   {
      taskList.add(task);
   }

   @Override
   public synchronized Task get()
   {
      return taskList.getAndRemoveNextTask();
   }

   @Override
   public synchronized int size()
   {
      return taskList.size();
   }

}
