public class ThreadSafeBoundedQueue<T> implements QueueADT<T> {

    private BoundedArrayQueue queue;

    public ThreadSafeBoundedQueue(int capacity) {
        this.queue = new BoundedArrayQueue(capacity);
    }

    @Override
    public synchronized void enqueue(T element) {
        queue.enqueue(element);
    }

    @Override
    public synchronized T dequeue() {
        return (T)this.queue.dequeue();
    }

    @Override
    public synchronized T first() {
        return (T)this.queue.first();
    }

    @Override
    public synchronized int indexOf(T element) {
        return this.queue.indexOf(element);
    }

    @Override
    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public synchronized int size() {
        return this.queue.size();
    }

}
