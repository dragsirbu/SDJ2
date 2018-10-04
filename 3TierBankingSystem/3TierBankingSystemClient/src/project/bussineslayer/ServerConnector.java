package project.bussineslayer;

import project.bussineslayer.model.interfaces.IBankController;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerConnector  {

    private static final String HOST = "localhost";
    private static final int PORT = 1099;

    private static ServerConnector serverConnector;
    private IBankController bank;

    private ServerConnector() {
        try {
//            bank = (IBankController) Naming.lookup("rmi://localhost:1099/bank");
            Registry registry = LocateRegistry.getRegistry(HOST,PORT);
            bank = (IBankController) registry.lookup("bank");
        } catch (Exception e) {
            System.out.println("Exception connecting to the server");
            e.printStackTrace();
        }
    }

    public static ServerConnector getServerConnector() {
        if (serverConnector == null)
            serverConnector = new ServerConnector();
        return serverConnector;
    }

    public IBankController getBank() {
        return bank;
    }
}
