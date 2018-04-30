import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReplyTo extends Remote {
    void replyMessage(String msg) throws RemoteException;
}
