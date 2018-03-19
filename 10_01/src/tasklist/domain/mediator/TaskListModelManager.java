package tasklist.domain.mediator;

import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;

public class TaskListModelManager implements TaskListModel {

    private TaskList taskList;

    public  TaskListModelManager() {
        this.taskList = new TaskList();
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
