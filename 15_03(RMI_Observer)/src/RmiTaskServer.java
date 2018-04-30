import utility.observer.AbstractRemoteSubject;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiTaskServer extends AbstractRemoteSubject implements RemoteTaskList  {

    private GenQueue<Task> queue;
    public RmiTaskServer() {
        super();
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
        notifyObservers("Task added: "+task.toString());
        this.queue.enqueue(task);
        System.out.println(">Task added: "+task);
    }

    @Override
    public Task remove() {
        System.out.println(">Task removed.");
        Task toRemove = queue.dequeue();
        notifyObservers("Task removed: "+toRemove.toString());
        return toRemove;
    }

    @Override
    public int size() {
        System.out.println(">Size sent.");
        notifyObservers("Size: "+this.queue.size());
        return this.queue.size();
    }
}
