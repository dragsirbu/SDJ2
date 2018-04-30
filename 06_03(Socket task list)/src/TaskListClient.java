import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TaskListClient {

    private Scanner input;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    public TaskListClient(String host,int port) throws IOException {
        this.socket = new Socket(host,port);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.input = new Scanner(System.in);
    }

    public void execute() throws IOException {
        int choice;
        Package clientPackage = new Package(Package.EXIT);
        while(true) {
//            System.out.println("Conected to server: localhost at port 4556");
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
                System.out.print("Enter estimated time: ");
                long time = input.nextInt();
                clientPackage = new Package(Package.ADD,new Task(taskString,time));
            }
            else if (choice == 2) {
                clientPackage = new Package(Package.GET);
            }
            else if(choice == 3) {
                clientPackage = new Package(Package.SIZE);
            }
            else if(choice == 0){
                break;
            }
            Gson gson = new Gson();
            String taskJson = gson.toJson(clientPackage);
            out.writeUTF(taskJson);
            String serverReply = in.readUTF();
            gson = new Gson();
            Package serverPackage = gson.fromJson(serverReply,Package.class);
            System.out.println("Server> "+serverPackage.toString());


        }
    }
}
