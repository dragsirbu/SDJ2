import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer {

    private ServerSocket welcomeSocket;
    private TaskList taskList;

    public TaskListServer(TaskList taskList, int port) throws IOException {
        this.taskList = taskList;
        this.welcomeSocket = new ServerSocket(port);
    }
    public void execute() {
        try{
            while (true) {
                Socket clientSocket = welcomeSocket.accept();
                Thread clientThread =
                        new Thread(new TaskListCommunicationThreadHandler(clientSocket,this.taskList));
                clientThread.start();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
