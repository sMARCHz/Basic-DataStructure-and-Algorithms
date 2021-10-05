package challenge;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class QueueChallenge {

    // Challenge#1
    // Using a queue, determine whether string is palindrome
    // Ignore punctuation and spaces

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        // solution
        LinkedList<Character> queue = new LinkedList<>();
        LinkedList<Character> stack = new LinkedList<>();
        String stringNoPunctuation = string.toLowerCase().replaceAll("[^a-z]", "");

        for (int i = 0; i < stringNoPunctuation.length(); i++) {
            char c = stringNoPunctuation.charAt(i);
            queue.addLast(c);
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }

        return true;
    }
}
