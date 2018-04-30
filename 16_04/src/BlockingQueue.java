public class BlockingQueue<T>  implements Buffer<T> {
    private BoundedArrayQueue<T> queue;

    public  BlockingQueue(int capacity) {
        queue = new BoundedArrayQueue<>(capacity);
    }

    @Override
    public synchronized void put(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        while(this.isFull()) {
            try {
                System.out.println("Queue is full. Waiting!");
                wait();
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Putting.");
        queue.enqueue(element);
    }

    @Override
    public synchronized T take() {
        while(this.isEmpty()) {
            try {
                System.out.println("Queue is empty. Waiting!");
                wait();
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Taking!");
        return queue.dequeue();
    }

    @Override
    public synchronized T look() {
        if (isEmpty()) {
            return null;
        }
        return queue.first();
    }

    @Override
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public synchronized boolean isFull() {
        return queue.isFull();
    }

    @Override
    public synchronized int size() {
        return queue.size();
    }
}
