
import java.util.Arrays;

public class ArrayQueue<T> implements QueueADT<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private T[] queue;
    private int count;
    private int front;

    public ArrayQueue(int initialCapacity) {
        if (initialCapacity <= 0)
            initialCapacity = DEFAULT_CAPACITY;

        this.queue = (T[]) new Object[initialCapacity];
        this.count = 0;
        this.front = 0;
    }

    public ArrayQueue() {
        this.queue = (T[]) new Object[DEFAULT_CAPACITY];
        this.count = 0;
        this.front = 0;
    }

    @Override
    public void enqueue(T element) {
        if (count >= queue.length)
            expandCapacity();

        queue[count] = element;
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("The queue is empty");

        T temp = queue[front];
        queue[front] = null;
        front++;

        return temp;
    }

    @Override
    public T first() {
        if (isEmpty())
            throw new IllegalStateException("The queue is empty");

        return queue[front % queue.length];
    }

    @Override
    public int indexOf(T element) {
        if (element == null) {
            for (int i = front % queue.length; i < queue.length + front; i++)
                if (queue[i % queue.length] == null)
                    return i - front % queue.length;
        } else {
            for (int i = front % queue.length; i < queue.length + front; i++) {
                if (queue[i % queue.length] == null)
                    continue;
                else if (queue[i % queue.length].equals(element))
                    return i - front % queue.length;
            }
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return (count - front) == 0;
    }

    @Override
    public int size() {
        return count - front;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (!isEmpty()) {
            for (int i = 0; front+i < count; i++)
                if (front + i < queue.length)
                    sb.append(queue[front+i]).append(", ");
                else
                    sb.append(queue[front+i-queue.length]).append(", ");
            sb.setLength(sb.length()-2);
        }
        sb.append("}");
        return sb.toString();
    }

    private void expandCapacity() {
        T[] newQueue = (T[]) new Object[queue.length * 2];

        for (int i = 0; i < queue.length; i++)
            newQueue[i] = queue[i];

        queue = newQueue;
    }
}