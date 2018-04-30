import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends InterImpl {
    public Server() {super();};

    public static void main(String[] args) {
        try {
//            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            InterImpl obj = new InterImpl();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Hello",stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println("Exception occured!");
            e.printStackTrace();
        }

    }
}
