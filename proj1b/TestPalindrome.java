import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String t1 = "noon";
        assertTrue(palindrome.isPalindrome(t1));

        String t2 = "cat";
        assertFalse(palindrome.isPalindrome(t2));

        String t3 = "a";
        assertTrue(palindrome.isPalindrome(t3));

        String t4 = "Aa";
        assertFalse(palindrome.isPalindrome(t4));

        String t5 = "";
        assertTrue(palindrome.isPalindrome(t5));

        String t6 = "abcba";
        assertTrue(palindrome.isPalindrome(t6));
    }

    @Test
    public void testIsPalindrome2() {
        CharacterComparator cc = new OffByOne();
        String t1 = "abcb";
        assertTrue(palindrome.isPalindrome(t1, cc));

        String t2 = "abba";
        assertFalse(palindrome.isPalindrome(t2, cc));

        String t3 = "a";
        assertTrue(palindrome.isPalindrome(t3, cc));

        String t4 = "Ab";
        assertFalse(palindrome.isPalindrome(t4, cc));

        String t5 = "";
        assertTrue(palindrome.isPalindrome(t5, cc));

        String t6 = "flake";
        assertTrue(palindrome.isPalindrome(t6, cc));
    }
}
