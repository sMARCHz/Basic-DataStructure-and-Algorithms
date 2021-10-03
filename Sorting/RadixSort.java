package Sorting;

public class RadixSort {

    // O(n) but need to make assumption about value
    // Radix = number of unique digits (i.e. decimalNumber=10, alphabet=26)
    // Width = length of the value
    // Need stable sort algorithm for sorting (In this case is stable counting sort)
    // Sort based on individual digit
    // Can sort the string and integer
    public static void main(String[] args) {
        int[] array = {4725, 4586, 1330, 8792, 1594, 5729};
        radixSort(array, 4, 10);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void radixSort(int[] array, int width, int radix) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(array, i, radix);
        }
    }

    private static void radixSingleSort(int[] array, int position, int radix) {
        int numsItem = array.length;
        int[] countArray = new int[radix];
        for (int i : array) {
            countArray[getDigit(i, position, radix)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numsItem];
        for (int tempIndex = numsItem - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(array[tempIndex], position, radix)]] = array[tempIndex];
        }

        System.arraycopy(temp, 0, array, 0, numsItem);
    }

    private static int getDigit(int value, int position, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
