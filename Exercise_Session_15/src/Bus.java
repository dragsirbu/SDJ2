import utility.observer.AbstractRemoteSubject;

import java.util.*;

public class Bus extends AbstractRemoteSubject
{
    private String info;
    private ArrayList<BusPassenger> list;
    public Bus()
    {
        this.info = "eXpress " + hashCode() % 100;
        this.list = new ArrayList<>();
    }
    public void passengerGettingIn(BusPassenger p)
    {
        list.add(p);
        notifyObservers("Enter: "+p.getName());
        try {
            addObserver(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void passengerGettingOut(BusPassenger p)
    {
        try {
            deleteObserver(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.remove(p);
        notifyObservers("Getting out: "+p.getName());
    }
    public String getInfo()
    {
        return info;
    }

    public List<BusPassenger> getPassengerList() {
        return list;
    }

    public String toString()
    {
        return getInfo() + ":\n" + getPassengerList();
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Bus))
            return false;
        Bus b = (Bus) obj;
        return info.equals(b.info);
    }
}