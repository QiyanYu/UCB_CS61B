package synthesizer;

public interface BoundedQueue<T> {
    int capacity();

    int fillCount();

    default boolean isEmpty() {
        return fillCount() == 0;
    }

    default boolean isFull() {
        return fillCount() == capacity();
    }

    void enqueue(int x);

    T dequeue();

    T peek();
}
