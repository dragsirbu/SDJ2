import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public Client() {};

    public static void main(String[] args) {
        Hello server;
        try {
           server =(Hello) Naming.lookup("rmi://localhost:1099/Hello");
           server.printMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
