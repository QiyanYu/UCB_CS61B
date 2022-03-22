public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        this.nextFirst = items.length / 2;
        this.nextLast = nextFirst + 1;
    }

    private int addOne(int index, int arrLen) {
        return (index + 1) % arrLen;
    }

    private int minusOne(int index) {
        index--;
        return index >= 0 ? index : items.length + index;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int newNextFirst = capacity / 2;
        int newNextLast = newNextFirst + 1;
        int i = addOne(nextFirst, items.length);
        while (i != nextLast) {
            newItems[newNextLast] = items[i];
            newNextLast = addOne(newNextLast, capacity);
            i = addOne(i, items.length);
        }
        this.nextFirst = newNextFirst;
        this.nextLast = newNextLast;
        this.items = newItems;
    }

    public void addFirst(T item) {
        if (nextLast == nextFirst) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }


    public void addLast(T item) {
        if (nextLast == nextFirst) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        nextLast = addOne(nextLast, items.length);
        size++;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        int i = addOne(nextFirst, items.length);
        while (i != nextLast) {
            System.out.print(items[i] + " ");
            i = addOne(i, items.length);
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        nextFirst = addOne(nextFirst, items.length);
        size--;
        T ret = items[nextFirst];
        if (size < items.length / 4) {
            resize(items.length / 2);
        }
        return ret;
    }

    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        size--;
        T ret = items[nextLast];
        if (size < items.length / 4) {
            resize(items.length / 2);
        }
        return ret;
    }

    public T get(int index) {

        int i = addOne(index + nextFirst, items.length);
        return items[i];
    }
}
