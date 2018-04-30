public class QueueListBased<T> implements QueueADT<T> {

    private ListADT<T> list;
    private int count;
    private int front;

    public QueueListBased() {
        list = new ArrayList<>();
        this.count = 0;
        this.front = 0;
    }

    @Override
    public void enqueue(T element) {
        list.add(count,element);
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("The queue is empty");

        return list.remove(0);
    }

    @Override
    public T first() {
        if (isEmpty())
            throw new IllegalStateException("The queue is empty");

        return list.remove(0);
    }

    @Override
    public int indexOf(T element) {
        return list.indexOf(element);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return list.isFull();
    }

    @Override
    public int size() {
        return list.size();
    }

}
