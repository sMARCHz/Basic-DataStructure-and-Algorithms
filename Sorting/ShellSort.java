package Sorting;

public class ShellSort {

    // O(nlog(n)), Worst: O(n^2)
    // Unstable
    // Similar to insertion sort but with gap
    public static void main(String[] args) {
        int[] array = {20, -1, 59, 48, 0, -22};
        shellSort(array);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int element = array[j];
                while (j >= gap && element < array[j - gap]) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = element;
            }
        }
    }
}
