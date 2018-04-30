import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList,Serializable {


    private ArrayList<String> list;

    public RemoteMessageServer()  throws RemoteException{
        super();
        this.list = new ArrayList<>();
        try {
            RemoteMessageList stub = (RemoteMessageList) UnicastRemoteObject.exportObject(this,0);
            Naming.rebind("Messagelist", stub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addMessage(String msg) {
        this.list.add(msg);
        System.out.println("To be added> "+msg);
    }

    public static void main(String[] args) {
        try {
//            RemoteMessageList stub = (RemoteMessageList) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            RemoteMessageServer server = new RemoteMessageServer();
//            registry.rebind("Messagelist",server);
            System.out.println("Server started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
