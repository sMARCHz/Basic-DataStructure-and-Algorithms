public class QuickSort {

    // O(nlog(n)), Worst: O(n^2)
    // Unstable
    // Create pivot then sort based on pivot (smaller value to the left of pivot and larger to the right) then repeat it
    // Is considered better than mergeSort because it doesn't need extra space, worst case can avoid by using randomized quicksort, etc.
    public static void main(String[] ars) {
        int[] array = {20, -1, 59, 48, 0, -22};
        quickSort(array, 0, array.length);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && array[--j] >= pivot) ;
            if (i < j) {
                array[i] = array[j];
            }

            while (i < j && array[++i] <= pivot) ;
            if (i < j) {
                array[j] = array[i];
            }
        }

        array[j] = pivot;
        return j;
    }
}
