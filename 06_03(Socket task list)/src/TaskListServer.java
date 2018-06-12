import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer {

    private ServerSocket welcomeSocket;
    private TaskList taskList;

    public TaskListServer(TaskList taskList,int port) {
        this.taskList = taskList;
        try {
            this.welcomeSocket = new ServerSocket(port);
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public void execute() {
        while (true) {
            try {
                Socket clientSocket = welcomeSocket.accept();
                TaskListCommunicationThreadHandler handler =
                        new TaskListCommunicationThreadHandler(clientSocket,taskList);
                handler.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}