package tasklist.domain.mediator;

import tasklist.domain.model.Task;

public interface TaskListModel
{
   void add(Task task);
   Task get();
   int size();  
}
