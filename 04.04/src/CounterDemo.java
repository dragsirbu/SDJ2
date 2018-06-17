public class CounterDemo {

    public static void main(String[] args) {
        Counter counter = new Counter(5,20);

        CounterDecrementer dec1 = new CounterDecrementer(counter,200);
        CounterDecrementer dec2 = new CounterDecrementer(counter,200);

        CounterIncrementer inc1 = new CounterIncrementer(counter,200);
        CounterIncrementer inc2 = new CounterIncrementer(counter,200);

        Thread t1 = new Thread(dec1);
        Thread t2 = new Thread(dec2);
        Thread t3 = new Thread(inc1);
        Thread t4 = new Thread(inc2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("Main ended!");
    }
}
