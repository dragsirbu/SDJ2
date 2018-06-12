public class ServerMain {

    public static void main(String[] args) {

        final int PORT = 6789;

        TaskList taskList = TaskList.getInstance();
        System.out.println("Server waiting for client...");
        try {
            TaskListServer server = new TaskListServer(taskList,PORT);
            server.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
