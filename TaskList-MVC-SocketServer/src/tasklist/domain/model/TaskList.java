package tasklist.domain.model;
import java.util.ArrayList;

public class TaskList
{
   private ArrayList<Task> tasks;
   
   public TaskList()
   {
      tasks = new ArrayList<Task>();
   }
   public void add(Task task)
   {
      tasks.add(task);
   }
   public Task getAndRemoveNextTask()
   {
      Task task = null;
      if (tasks.size() > 0)
      {
         task = tasks.get(0);
         tasks.remove(0);
      }
      return task;
   }
   public int size()
   {
      return tasks.size();
   }
   public String toString()
   {
      return "Tasks=" + tasks;
   }
}
