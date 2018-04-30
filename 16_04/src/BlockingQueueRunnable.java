public class BlockingQueueRunnable implements Runnable {
    private boolean type;
    private BlockingQueue queue;
    public  BlockingQueueRunnable(BlockingQueue<String> queue, boolean type) {
        this.queue = queue;
        this.type = type;
    }

    @Override
    public synchronized void run() {
        if (type) {
            queue.put("Hi");
            queue.put("Hello");
            queue.put("Hola");
            queue.put("Hallo");
        } else {
            queue.take();
            queue.take();
            queue.take();
            queue.take();
        }
    }
}
