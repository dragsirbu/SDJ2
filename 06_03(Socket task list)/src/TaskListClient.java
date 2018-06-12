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

  public TaskListClient(String host, int port) {
      try {
          this.socket = new Socket(host, port);
          in = new DataInputStream(socket.getInputStream());
          out = new DataOutputStream(socket.getOutputStream());
      } catch (IOException e) {
          e.printStackTrace();
      }
      input = new Scanner(System.in);
  }

  public void execute() throws IOException {
      int choice;
      Package clientPackage = new Package(Package.EXIT);
      while (true) {
          System.out.println("1) Type 1 for \"ADD\"");
          System.out.println("2) Type 2 to \"GET\"");
          System.out.println("3) Type 3 to get the \"SIZE\"");
          System.out.println("0) Type 0 to \"EXIT\"");
          System.out.print("Enter choice: ");
          choice = input.nextInt();
          input.nextLine();

          if (choice == 1) {
              System.out.print("Enter task: ");
              String task = input.nextLine();
              System.out.print("Enter estimated time: ");
              long time = input.nextInt();
              input.nextLine();
              Task toAdd = new Task(task,time);
              clientPackage = new Package(Package.ADD,toAdd);
          }
          else if (choice == 2) {
              clientPackage = new Package(Package.GET);
          }
          else if (choice == 3) {
              clientPackage = new Package(Package.SIZE);
          }
          else if (choice == 0) {
              break;
          }
          else {
              System.out.println("Invalid choice");
          }

          System.out.println("Client> "+clientPackage.toString());
          Gson gson = new Gson();
          String requestJson = gson.toJson(clientPackage);
          String replyJson;
          out.writeUTF(requestJson);
          replyJson = in.readUTF();
          Package reply = gson.fromJson(replyJson,Package.class);
          System.out.println("Server> "+reply.getText());
          System.out.println("Task: "+reply.getTask());
      }
  }
}
