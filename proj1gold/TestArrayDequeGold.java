import org.junit.Test;

import static org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        String ret = "";

        for (int i = 0; i < 10000; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25) {
                sad1.addLast(i);
                ads1.addLast(i);
                ret += "addLast(" + i + ")\n";
                for (int j = 0; j < sad1.size(); j++) {
                    assertEquals(ret, sad1.get(j), ads1.get(j));
                }
            } else if (numberBetweenZeroAndOne < 0.5) {
                sad1.addFirst(i);
                ads1.addFirst(i);
                ret += "addFirst(" + i + ")\n";
                for (int j = 0; j < sad1.size(); j++) {
                    assertEquals(ret, sad1.get(j), ads1.get(j));
                }
            } else if (numberBetweenZeroAndOne < 0.75 && !sad1.isEmpty()) {
                ret += "removeFirst()\n";
                assertEquals(ret, sad1.removeFirst(), ads1.removeFirst());
            } else if (!sad1.isEmpty()) {
                ret += "removeLast()\n";
                assertEquals(ret, sad1.removeLast(), ads1.removeLast());
            }
        }

        sad1.printDeque();
    }
}
