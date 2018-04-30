import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        RmiTaskClient client = new RmiTaskClient("localhost");
        client.start();
    }
}
