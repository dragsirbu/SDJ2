package tasklist.controller;

import tasklist.domain.mediator.TaskListModel;
import tasklist.domain.model.Task;
import tasklist.view.TaskListView;

import java.util.Scanner;

public class ClientTaskListController {

    private TaskListModel model;
    private TaskListView view;

    public ClientTaskListController(TaskListModel model, TaskListView view) {
        this.model = model;
        this.view = view;
    }

    public void execute(int choice) {
        Scanner scan = new Scanner(System.in);
        switch (choice) {
            case 1: {
                String taskName = view.get("Enter task: ");
//                System.out.println(taskName);
//                scan.nextLine();
                String timeString = view.get("Enter time: ");
                long time = Long.parseLong(timeString);
                Task newTask = new Task(taskName,time);
                model.add(newTask);
//                System.out.print("Task added: "+taskName);
                view.show("Task added: "+newTask.toString());
                break;
            }
            case 2: {
                view.show(model.get().toString());
                break;
            }
            case 3: {
                view.show("Size: "+model.size());
                break;
            }
            case 0: {
                System.exit(0);
                break;
            }

        }
    }
}
