public class Counter  {

    private long value;
    private long max;
    private long min;

    public Counter(long min, long max) {
        this.value = 0;
        this.min = min;
        this.max = max;
    }

    public synchronized void increment() {
        while(value >= max)
            try {
                wait();
                notifyAll();
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
        this.value++;
        System.out.println(value + ": " + Thread.currentThread().getName());
    }

    public synchronized void decrement() {
        while (value <= min) {
            try {
                wait();
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value--;
        System.out.println(value + ": " + Thread.currentThread().getName());
    }

    public synchronized long getValue() {
        return this.value;
    }
}
