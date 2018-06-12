package tasklist.controller;

import tasklist.domain.mediator.TaskListModel;
import tasklist.domain.model.Task;
import tasklist.view.TaskListView;

public class TaskListController
{
   private TaskListView view;
   private TaskListModel model;

   public TaskListController(TaskListModel model, TaskListView view)
   {
      this.model = model;
      this.view = view;
   }

   public void execute(int choice)
   {
      switch (choice)
      {
         case 1:
            String taskText = view.get("task");
            String taskTime = view.get("estimated task time");
            long time = -1;
            try
            {
               time = Long.parseLong(taskTime);
            }
            catch (NumberFormatException e)
            {
            }
            Task task = new Task(taskText, time);
            model.add(task);
            view.show("ADDED: " + task);
            break;
         case 2:
            task = model.get();
            view.show("Task: "+task);
            break;
         case 3:
            int size = model.size();
            view.show("Size=" + size);
            break;
         case 0:
            System.exit(1);
            break;
      }
   }
}
