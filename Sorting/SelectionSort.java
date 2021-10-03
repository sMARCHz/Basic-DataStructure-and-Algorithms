package Sorting;

public class SelectionSort {

    // Worst: O(n^2)
    // Unstable
    // Select the largestValue then swap to the right
    public static void main(String[] args) {
        int[] array = {20, -1, 59, 48, 0, -22};
        selectionSort(array);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void selectionSort(int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int indexOfLargestValue = 0;
            for (int j = 1; j <= lastUnsortedIndex; j++) {
                if (array[j] > array[indexOfLargestValue]) {
                    indexOfLargestValue = j;
                }
            }
            swap(array, indexOfLargestValue, lastUnsortedIndex);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
