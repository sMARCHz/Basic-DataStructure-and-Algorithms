package Sorting;

public class InsertionSort {

    // Worst: O(n^2)
    // Stable
    // Insert value to sortedArray which is on the left
    public static void main(String[] args) {
        int[] array = {20, -1, 59, 48, 0, -22};
        insertionSort(array);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void insertionSort(int[] array) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int firstUnsortedValue = array[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && firstUnsortedValue < array[i - 1]; i--) {
                array[i] = array[i - 1];
            }

            array[i] = firstUnsortedValue;
        }
    }
}
