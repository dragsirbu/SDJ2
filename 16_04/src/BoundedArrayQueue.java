

import java.security.cert.TrustAnchor;
import java.util.Arrays;

public class BoundedArrayQueue<T> implements QueueADT<T> {
    private T[] queue;
    private int count;
    private int front;

    public BoundedArrayQueue(int capacity) {
        if (capacity <= 0)
            capacity = 0;

        this.queue = (T[]) new Object[capacity];
        this.count = 0;
        this.front = 0;
    }

    @Override
    public void enqueue(T element) {
        if (count < queue.length) {
            queue[count] = (T) element;
            count++;
        } else if (queue.length > 0 && count >= queue.length && count % queue.length != front) {
            queue[count % queue.length] = element;
            count++;
        } else {
            throw new IllegalStateException("The queue is full :(");
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("The queue is empty");

        T temp = queue[front % queue.length];
        queue[front % queue.length] = null;
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
    public boolean isFull() {
        return count == queue.length;
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
}