package tasklist.view;

import tasklist.controller.TaskListController;

public interface TaskListView
{
   String get(String string);
   void show(String text);
   void startView(TaskListController controller);
}
