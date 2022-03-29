package synthesizer;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.rb = (T[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (this.isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        this.rb[this.last] = x;
        this.last = addOne(this.last);
        this.fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T temp = this.rb[this.first];
        this.first = addOne(this.first);
        this.fillCount--;
        return temp;
    }

    /**
     * Return the index of the next item in the ring buffer.
     *
     * @param i the index of the current item
     * @return the index of the next item
     */
    private int addOne(int i) {
        return (i + 1) % this.capacity;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return this.rb[this.first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    @Override
    public Iterator<T> iterator() {
        return new ARBufferIterator();
    }

    private class ARBufferIterator implements Iterator<T> {
        private int ptr;

        public ARBufferIterator() {
            this.ptr = first;
        }

        public boolean hasNext() {
            return ptr != last;
        }

        public T next() {
            return rb[ptr++];
        }
    }
}
