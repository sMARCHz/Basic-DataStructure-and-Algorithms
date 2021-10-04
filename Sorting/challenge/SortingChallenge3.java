package Sorting.challenge;

public class SortingChallenge3 {

    // Challenge#3
    // Sort String array using radix sort

    public static void main(String[] args) {
        String[] stringsArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        radixSort(stringsArray, 5, 26);

        for (String s : stringsArray) {
            System.out.println(s);
        }
    }

    public static void radixSort(String[] strArray, int width, int radix) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSort(strArray, i, radix);
        }
    }

    private static void radixSingleSort(String[] strArray, int position, int radix) {
        int numsItem = strArray.length;
        int[] countArray = new int[radix];
        for (String i : strArray) {
            countArray[getIndex(i, position)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numsItem];
        for (int tempIndex = numsItem - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(strArray[tempIndex], position)]] = strArray[tempIndex];
        }

        System.arraycopy(temp, 0, strArray, 0, numsItem);
    }

    private static int getIndex(String value, int position) {
        return value.charAt(position) - 'a';
    }
}
