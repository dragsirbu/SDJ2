public class CounterIncrementer implements Runnable {

    private int updates;
    private Counter counter;

    public CounterIncrementer(Counter counter, int updates) {
        this.counter = counter;
        this.updates = updates;
    }

    @Override
    public void run() {
        for (int i = 0; i < updates; i++) {
            counter.increment();
        }
    }
}
