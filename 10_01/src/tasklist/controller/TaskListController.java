package tasklist.controller;

import tasklist.domain.mediator.TaskListModel;
import tasklist.domain.mediator.TaskListModelManager;
import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;
import tasklist.view.TaskListConsole;
import tasklist.view.TaskListView;

import java.util.Scanner;

public class TaskListController {

    private TaskListModel model;
    private TaskListView view;

    public TaskListController(TaskListModel model, TaskListView view) {
        this.model = model;
        this.view = view;
    }

    public void execute(int choice) {
        Scanner scan = new Scanner(System.in);
        switch (choice) {
            case 1: {
                String taskName = view.get("Enter task: ");
                String timeString = view.get("Enter time: ").trim();
                System.out.println(timeString);
                long time = Long.parseLong(timeString);
                model.add(new Task(taskName,time));
                System.out.print("Task added: ");
                view.show(taskName);
                break;
            }
            case 2: {
                view.show(model.get().toString());
                break;
            }
            case 3: {
                view.show(model.size()+"");
                break;
            }
            case 0: {
                System.exit(0);
                break;
            }

        }
    }
}
