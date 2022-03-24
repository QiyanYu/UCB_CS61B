public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> ret = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            ret.addLast(word.charAt(i));
        }
        return ret;
    }

    public boolean isPalindrome(String word) {
        int len = word.length();
        if (len <= 1) {
            return true;
        }
        Deque<Character> lst = wordToDeque(word);
        for (int i = 0; i < len / 2; i++) {
            if (lst.removeFirst() != lst.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int len = word.length();
        if (len <= 1) {
            return true;
        }
        Deque<Character> lst = wordToDeque(word);
        for (int i = 0; i < len / 2; i++) {
            if (!cc.equalChars(lst.removeFirst(), lst.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
