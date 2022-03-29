package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertEquals(0, arb.fillCount());
        arb.enqueue(1);
        assertEquals(1, arb.fillCount());
        arb.enqueue(2);
        assertEquals(2, arb.fillCount());
        arb.enqueue(3);
        assertEquals(3, arb.fillCount());
        arb.enqueue(4);
        assertEquals(4, arb.fillCount());
        arb.enqueue(5);
        assertEquals(5, arb.fillCount());
        arb.enqueue(6);
        assertEquals(6, arb.fillCount());
        arb.enqueue(7);
        assertEquals(7, arb.fillCount());
        arb.enqueue(8);
        assertEquals(8, arb.fillCount());
        arb.enqueue(9);
        assertEquals(9, arb.fillCount());
        arb.enqueue(10);
        assertEquals(10, arb.fillCount());
//        arb.enqueue(11);
//        assertEquals(10, arb.fillCount());
        arb.dequeue();
        assertEquals(9, arb.fillCount());
        arb.dequeue();
        assertEquals(8, arb.fillCount());
        arb.dequeue();
        assertEquals(7, arb.fillCount());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
