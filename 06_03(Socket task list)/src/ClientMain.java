public class ClientMain {
    public static void main(String[] args) {

        final String HOST = "localhost";
        final int PORT = 4556;

        try {
            TaskListClient client = new TaskListClient(HOST, PORT);
            client.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
