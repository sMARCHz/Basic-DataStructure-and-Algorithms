package Sorting.challenge;

public class SortingChallenge2 {

    // Challenge#2
    // Modify insertionSort to use recursion

    public static void main(String[] args) {
        // First solution
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        insertionSort(intArray, 1);

        // Second solution
        int[] intArray2 = {20, 35, -15, 7, 55, 1, -22};
        insertionSort2(intArray2, intArray.length);

        for (int i : intArray) {
            System.out.println(i);
        }
    }

    public static void insertionSort(int[] intArray, int firstUnsortedIndex) {
        if (firstUnsortedIndex == intArray.length) {
            return;
        }
        int newElement = intArray[firstUnsortedIndex];
        int i;
        for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
            intArray[i] = intArray[i - 1];
        }
        intArray[i] = newElement;
        insertionSort(intArray, ++firstUnsortedIndex);
    }

    public static void insertionSort2(int[] input, int numsItem) {
        if (numsItem < 2) {
            return;
        }

        insertionSort2(input, numsItem - 1);

        int newElement = input[numsItem - 1];
        int i;
        for (i = numsItem - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }
        input[i] = newElement;
    }
}
