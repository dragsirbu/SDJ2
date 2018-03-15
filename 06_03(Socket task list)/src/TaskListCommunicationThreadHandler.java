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

    public TaskListCommunicationThreadHandler(Socket socket, TaskList taskList) throws IOException {
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.ip = socket.getRemoteSocketAddress().toString();
        this.taskList = taskList;
    }

    @Override
    public void run() {

        try {
            while(true) {
                Gson gson = new Gson();
                String fromClient = in.readUTF();
                Package clientMessage = gson.fromJson(fromClient,Package.class);
                Package taskPackage = operation(clientMessage);
                if (taskPackage.getText().equals(Package.EXIT))
                    break;
                gson = new Gson();
                String replyJson = gson.toJson(taskPackage);
                out.writeUTF(replyJson);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    private Package operation(Package request) {
        switch (request.getText()) {
            case "ADD" : {
                Package toAdd = new Package(Package.ADD, request.getTask());
                taskList.add(toAdd.getTask());
                return toAdd;
            }
            case "GET":{
                if(taskList.size() == 0)
                    return new Package("NO TASKS - EMPTY TASK LIST");
                return new Package(Package.GET,taskList.getAndRemoveNextTask());
            }
            case "SIZE":
                return new Package(Package.SIZE+"= "+taskList.size());
            case "EXIT":
                return new Package(Package.EXIT);
            default:
                return new Package("WRONG FORMAT");

        }
    }
}
