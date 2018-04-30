import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageClient extends UnicastRemoteObject {
    private RemoteMessageList server;
    public RemoteMessageClient() throws RemoteException {
        super();
        try {
            server = (RemoteMessageList) Naming.lookup("rmi://localhost/Messagelist");
            String input;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                System.out.print("Enter task or quit to cancel: ");
                input = reader.readLine();
                if (input.toLowerCase().equals("quit"))
                    break;
                server.addMessage(input);
                System.out.println("Message added.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            RemoteMessageClient client = new RemoteMessageClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
