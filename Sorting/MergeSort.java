package Sorting;

public class MergeSort {

    // O(nlog(n))
    // Stable
    // Divide and Conquer -> Scope to the smallest array then sort and merge to the array
    public static void main(String[] args) {
        int[] array = {20, -1, 59, 48, 0, -22};
        int start = 0;
        int end = array.length;
        int mid = (start + end) / 2;

        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        if (array[mid - 1] < array[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);
    }
}
