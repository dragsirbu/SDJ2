import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RemoteMessageClient extends UnicastRemoteObject
                                 implements Serializable,ReplyTo
{

    private RemoteMessageList server;

    @Override
    public void replyMessage(String msg) {
        System.out.println(msg);
    }

    public RemoteMessageClient() throws java.rmi.RemoteException {
        super();
        try {
            server = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/Messagelist");
            String input;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                System.out.print("Enter task or quit to cancel: ");
                input = reader.readLine();
                if (input.toLowerCase().equals("quit"))
                    break;
                server.addMessage(input,this);
                System.out.println("Message added.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws java.rmi.RemoteException {

//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        RemoteMessageClient client = new RemoteMessageClient();
    }
}
