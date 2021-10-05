public class CountingSort {

    // O(n) but need to make assumption about value range
    // Unstable but can be stable if add extra step
    // Example: Assume that integer in the array is 0-9. Create tempArray and loop through the inputArray. Count for value that has the same value as inputArray.
    public static void main(String[] args) {
        int[] array = {4, 1, 5, 8, 0, 2};
        countingSort(array, 0, 10);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void countingSort(int[] array, int min, int max) {
        int[] countArray = new int[(max - min) + 1];
        for (int i : array) {
            countArray[i - min]++;
        }

        int j = 0;
        for (int i = min; i < max; i++) {
            while (countArray[i - min] > 0) {
                array[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
