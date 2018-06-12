import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TaskListCommunicationThreadHandler implements Runnable {

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private String ip;
    private TaskList taskList;

    public TaskListCommunicationThreadHandler(Socket socket, TaskList taskList) {
        this.socket = socket;
        this.taskList = taskList;
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.ip = socket.getRemoteSocketAddress().toString();
    }



    @Override
    public void run() {
        while(true) {
            try {
                Gson gson = new Gson();
                String requestJson = in.readUTF();
                Package request = gson.fromJson(requestJson,Package.class);
                Package reply = this.operation(request);
                String replyJson = gson.toJson(reply);
                out.writeUTF(replyJson);
                if (reply.getText().equals(Package.EXIT))
                    break;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Package operation(Package request) {
        switch (request.getText()) {
            case "ADD":
               Package toAdd = new Package(Package.ADD,request.getTask());
               taskList.add(toAdd.getTask());
               return toAdd;
            case "GET":
                if (taskList.size() == 0)
                    return new Package("NO TASKS - EMPTY LIST");
                return new Package(Package.GET,taskList.getAndRemoveNextTask());
            case "SIZE":
                return new Package(Package.SIZE + " = " +taskList.size());
            case "EXIT":
                return new Package(Package.EXIT);
                default:
                    return new Package("WRONG FORMAT");
        }
    }

}
