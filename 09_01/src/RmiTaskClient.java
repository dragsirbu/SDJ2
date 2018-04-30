import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.Scanner;

public class RmiTaskClient {
    private RemoteTaskList server;
    public RmiTaskClient(String host) {
        try {
            server = (RemoteTaskList) Naming.lookup("rmi://localhost:1099/Tasklist");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void start() throws IOException {
        int choice;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1) Type 1 for \"ADD\"");
            System.out.println("2) Type 2 to \"GET\"");
            System.out.println("3) Type 3 to get the \"SIZE\"");
            System.out.println("0) Type 0 to \"EXIT\"");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            if (choice == 1) {
                input.nextLine();
                System.out.print("Enter task: ");
                String taskString = input.nextLine();
                Task task = new Task(taskString);
                server.add(task);
                System.out.println("Server> "+task.toString()+" added.");
            }
            else if (choice == 2) {
                Task removed = server.remove();
                System.out.println("Server> "+removed.toString()+" removed.");
            }
            else if(choice == 3) {
                System.out.println("Server> Size is "+server.size());
            }
            else if(choice == 0){
                break;
            }
        }
    }
}
