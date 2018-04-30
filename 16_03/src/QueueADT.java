public interface QueueADT<T> {
    void enqueue(T element);
    T dequeue();
    T first();
    int indexOf(T element);
    boolean isEmpty();
    boolean isFull();
    int size();
}