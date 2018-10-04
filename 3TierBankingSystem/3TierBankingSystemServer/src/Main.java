import project.bussineslayer.BankController;
import project.bussineslayer.model.interfaces.IBankController;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {

//    private static final String HOST = "localhost";
    private static final int PORT = 1099;

    public static void main(String[] args) {
        try {

            BankController bank = new BankController();

            Registry registry = LocateRegistry.createRegistry(PORT);

            IBankController stub = (IBankController) UnicastRemoteObject.exportObject(bank, 1099);

            Naming.rebind("bank",stub);

            System.out.println("Server ready.");
        } catch (Exception e) {
            System.out.println("Connection error!");
            e.printStackTrace();
        }
    }
}
