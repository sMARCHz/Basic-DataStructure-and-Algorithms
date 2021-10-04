package challenge;

import java.util.LinkedList;

public class StackChallenge {

    // Challenge#1
    // Using a stack, determine whether string is palindrome
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
        LinkedList<Character> stack = new LinkedList<>();
        String stringNoPunctuation = string.toLowerCase().replaceAll("[^a-zA-Z]", "");
        for (int i = 0; i < stringNoPunctuation.length(); i++) {
            stack.push(stringNoPunctuation.charAt(i));
        }

        StringBuilder reverseString = new StringBuilder();
        while (!stack.isEmpty()) {
            reverseString.append(stack.pop());
        }
        return String.valueOf(reverseString).equals(stringNoPunctuation);
    }
}
