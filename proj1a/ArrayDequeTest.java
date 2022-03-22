import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void test1() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertTrue(deque.isEmpty());

        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);

        deque.printDeque();

        deque.removeFirst();
        deque.printDeque();

        deque.removeLast();
        deque.printDeque();

        assertEquals(2, deque.size());
        deque.addFirst(3);
        deque.printDeque();
        deque.addFirst(4);
        deque.printDeque();
        deque.addFirst(5);
        deque.printDeque();
        deque.addFirst(6);
        deque.printDeque();
        deque.addFirst(7);
        deque.printDeque();

        assertEquals(4, (int) deque.get(3));
    }

    @Test
    public void testResizing() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < 16; i++) {
            deque.addLast(i);
        }
        for (int i = -16; i < 0; i++) {
            deque.addFirst(i);
        }
        for (int i = 0; i < 30; i++) {
            deque.removeFirst();
        }
        assertEquals(2, deque.size());
        deque.printDeque();
    }

    @Test
    public void test2() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        deque.printDeque();
        int t = deque.removeLast();
        System.out.println("this is removed " + t);
        deque.printDeque();
    }
}
