package tasklist.domain.mediator;

import tasklist.domain.model.Task;

public class ClientTaskListModelManager implements TaskListModel {

    private TaskListModel taskList;

    public ClientTaskListModelManager() {
        try {
            this.taskList = new TaskListClient("localhost",6789);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Task task) {
        taskList.add(task);
    }

    @Override
    public  Task get() {
        return taskList.get();
    }

    @Override
    public int size() {
        return taskList.size();
    }
}
