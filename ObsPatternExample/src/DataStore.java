import java.util.Observable;
public class DataStore extends Observable {
    private int data;

    public DataStore() {
        this.data = 0;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
        setChanged();
        notifyObservers(this.getData());
    }
}