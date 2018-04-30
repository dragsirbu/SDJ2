import utility.observer.AbstractRemoteSubject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTaskList extends Remote {
    void add(Task task) throws RemoteException;
    Task remove() throws RemoteException;
    int size() throws RemoteException;
}
