package tasklist.domain.mediator;

import tasklist.domain.model.TaskList;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer implements Runnable {

    private ServerSocket welcomeSocket;
    private TaskListModel taskList;

    public TaskListServer(TaskListModel taskList, int port) throws IOException {
        this.taskList = taskList;
        this.welcomeSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
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
