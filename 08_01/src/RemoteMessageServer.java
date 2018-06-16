import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList {

    private ArrayList<String> list;

    public RemoteMessageServer() {
        super();
        list = new ArrayList<>();
    }

    @Override
    public void addMessage(String msg, ReplyTo who) {
        list.add(msg);
        System.out.println("Server> To be added: "+msg);
        try {
            who.replyMessage("Thank you!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        if(System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }

        try {
            RemoteMessageList messageList = new RemoteMessageServer();
            RemoteMessageList stub = (RemoteMessageList) UnicastRemoteObject.exportObject(messageList,0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Messagelist",stub);
            System.out.println("MessageListServer bound");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
