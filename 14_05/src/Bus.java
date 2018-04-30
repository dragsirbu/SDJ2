import utility.observer.AbstractRemoteSubject;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;
import utility.observer.RemoteSubjectDelegate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
public class Bus implements RemoteSubject
{
    private RemoteSubjectDelegate remoteSubjectDelegate;
    private String info;
    private static Bus instance;
    private Bus()
    {
        this.info = "eXpress " + hashCode() % 100;
        this.remoteSubjectDelegate = new RemoteSubjectDelegate(this);
    }
    public static Bus getInstance() {
        if (instance == null) {
            instance = new Bus();
        }
        return instance;
    }
    public void passengerGettingIn(BusPassenger p)
    {
        remoteSubjectDelegate.notifyObservers("Enter: "+p.getName());
        try {
            remoteSubjectDelegate.addObserver(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void passengerGettingOut(BusPassenger p)
    {
        try {
            remoteSubjectDelegate.deleteObserver(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        remoteSubjectDelegate.notifyObservers("Getting out: "+p.getName());
    }
    public String getInfo()
    {
        return info;
    }
    public String toString()
    {
        return getInfo();
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Bus))
            return false;
        Bus b = (Bus) obj;
        return info.equals(b.info);
    }
    @Override
    public void addObserver(RemoteObserver obs) {

    }
    @Override
    public void deleteObserver(RemoteObserver obs) {

    }
}