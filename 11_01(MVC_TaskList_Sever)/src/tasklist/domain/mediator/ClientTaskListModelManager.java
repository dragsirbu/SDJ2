package tasklist.domain.mediator;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;

public class ClientTaskListModelManager implements TaskListModel {

    private TaskList taskList;
    private TaskListServer taskListServer;

    public ClientTaskListModelManager() {
        this.taskList = new TaskList();
        try {
            this.taskListServer = new TaskListServer(this, 6789);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread t = new Thread(taskListServer);
        t.start();
    }

    @Override
    public synchronized void add(Task task) {
        taskList.add(task);
    }

    @Override
    public synchronized Task get() {
        return taskList.getAndRemoveNextTask();
    }

    @Override
    public synchronized int size() {
        return taskList.size();
    }
}
