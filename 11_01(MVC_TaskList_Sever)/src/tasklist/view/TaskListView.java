package tasklist.view;

import tasklist.controller.ClientTaskListController;
public interface TaskListView
{
    String get(String text);
    void show(String text);
    void startView(ClientTaskListController controller);
}
