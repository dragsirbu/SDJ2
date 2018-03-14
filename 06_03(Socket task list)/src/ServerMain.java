public class ServerMain {

    public static void main(String[] args) {

        final int PORT = 4556;

        TaskList taskList = new TaskList();
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
