public class LinkedListDeque<T> {
    private class DequeNode {
        private T item;
        private DequeNode prev;
        private DequeNode next;

        DequeNode(T item, DequeNode prev, DequeNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private DequeNode sentinel;
    private int size;

    public LinkedListDeque() {
        this.sentinel = new DequeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        DequeNode newDequeNode = new DequeNode(item, sentinel, sentinel.next);
        sentinel.next.prev = newDequeNode;
        sentinel.next = newDequeNode;
        this.size++;
    }

    public void addLast(T item) {
        DequeNode newDequeNode = new DequeNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = newDequeNode;
        sentinel.prev = newDequeNode;
        this.size++;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void printDeque() {
        int count = this.size;
        DequeNode curr = sentinel;
        while (count-- > 0) {
            curr = curr.next;
            System.out.println(curr.item + " ");
        }
    }

    public T removeFirst() {
        if (this.size == 0) {
            return null;
        }

        DequeNode first = sentinel.next;
        DequeNode second = first.next;
        second.prev = sentinel;
        sentinel.next = second;
        size--;

        return first.item;
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        }

        DequeNode firstLast = sentinel.prev;
        DequeNode secondLast = firstLast.prev;
        secondLast.next = sentinel;
        sentinel.prev = secondLast;
        size--;

        return firstLast.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        DequeNode curr = sentinel;
        while (index-- >= 0) {
            curr = curr.next;
        }
        return curr.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(DequeNode node, int index) {
        if (index == 0) {
            return node.item;
        }

        return getRecursiveHelper(node.next, index - 1);
    }

    public int size() {
        return size;
    }
}
