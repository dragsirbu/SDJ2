public class Main {
    public static void main(String[] args) {

        BlockingQueue queue1 = new BlockingQueue(3);

        queue1.put("Hi");
        queue1.put("Hey");

        BlockingQueueRunnable r1 = new BlockingQueueRunnable(queue1,false);
        BlockingQueueRunnable r2 = new BlockingQueueRunnable(queue1,true);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t2.start();
        t1.start();

        System.out.println("Starting threads...");
    }

}
