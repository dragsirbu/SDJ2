import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiTaskServer implements RemoteTaskList {

    private GenQueue<Task> queue;
    public RmiTaskServer() {
        queue = new GenQueue<>();
        startRegistry();
        startServer();
    }

    private void startRegistry() {
        try {
           Registry registry = LocateRegistry.createRegistry(1099);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startServer() {
        try {
            RemoteTaskList stub = (RemoteTaskList) UnicastRemoteObject.exportObject(this,0);
            Naming.rebind("Tasklist",stub);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(Task task) {
        this.queue.enqueue(task);
        System.out.println(">Task added: "+task);
    }

    @Override
    public Task remove() {
        System.out.println(">Task removed.");
        return queue.dequeue();
    }

    @Override
    public int size() {
        System.out.println(">Size sent.");
        return this.queue.size();
    }
}
