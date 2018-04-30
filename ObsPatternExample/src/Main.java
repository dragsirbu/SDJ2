
public class Main {

    public static void main(String[] args) {
        Screen screen = new Screen();
        DataStore dataStore = new DataStore();
        dataStore.addObserver(screen);
        System.out.println("Data shows: "+dataStore.getData());
        for (int i=1;i<=5;i++) {
            dataStore.setData(i);
        }
    }
}


