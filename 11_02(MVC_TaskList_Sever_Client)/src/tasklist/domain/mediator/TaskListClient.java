package tasklist.domain.mediator;

import com.google.gson.Gson;
import tasklist.domain.model.Task;
import tasklist.domain.model.GenQueue;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TaskListClient implements TaskListModel {

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    public TaskListClient(String host,int port) throws IOException {
        this.socket = new Socket(host,port);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void add(Task task) {
        Package request = new Package(Package.ADD,task);
        reply(request);
    }

    @Override
    public Task get() {
        Package request = new Package(Package.GET);
        return  reply(request).getTask();
    }

    @Override
    public int size() {
        Package request = new Package(Package.SIZE);
        return Integer.parseInt(reply(request).getText());
    }

    private Package reply(Package request) {
        try {
            Gson gson = new Gson();
            String taskJson = gson.toJson(request);
            out.writeUTF(taskJson);
            String serverReply = in.readUTF();
            gson = new Gson();
            Package serverPackage = gson.fromJson(serverReply, Package.class);
            System.out.println("Server> " + serverPackage.toString());
            return serverPackage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
