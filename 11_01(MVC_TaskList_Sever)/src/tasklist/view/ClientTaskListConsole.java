package tasklist.view;

import tasklist.controller.ClientTaskListController;

import java.util.Scanner;

public class ClientTaskListConsole implements TaskListView, Runnable {

    private ClientTaskListController controller;
    private Scanner input;

    public ClientTaskListConsole() {
        this.input = new Scanner(System.in);
        this.controller = null;
    }

    @Override
    public void startView(ClientTaskListController controller) {
        this.controller = controller;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        int choice;
        while(true) {
            System.out.println("1) Type 1 for \"ADD\"");
            System.out.println("2) Type 2 to \"GET\"");
            System.out.println("3) Type 3 to get the \"SIZE\"");
            System.out.println("0) Type 0 to \"EXIT\"");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 0)
                break;
            this.controller.execute(choice);
        }
    }

    @Override
    public String get(String string) {
        System.out.print(string);
//        String message = input.nextLine();
//        System.out.println(message);
        return input.nextLine();
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }
}
