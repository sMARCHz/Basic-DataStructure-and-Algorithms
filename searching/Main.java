import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};

        // Linear search O(n)
        int[] linearSearchArray = new int[7];
        System.arraycopy(array, 0, linearSearchArray, 0, array.length);
        System.out.println("Found 55 at index: " + linearSearch(linearSearchArray, 55));

        // Binary search O(logn)
        int[] binarySearchArray = new int[7];
        System.arraycopy(array, 0, binarySearchArray, 0, array.length);
        Arrays.sort(binarySearchArray);
        System.out.print("\nSorted Array: ");
        for (int element : binarySearchArray) {
            System.out.print(element + ",");
        }
        System.out.println("\nFound 55 at index: " + binarySearch(binarySearchArray, -15));
        // Recursive binary search
        System.out.println("Found 55 at index (recursive): " + recursiveBinarySearch(binarySearchArray, 0, binarySearchArray.length, 7));
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // !! Binary Search's data must be sorted
    // O(logn)
    public static int binarySearch(int[] sortedArray, int target) {
        int start = 0;
        int end = sortedArray.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (sortedArray[mid] == target) {
                return mid;
            } else if (sortedArray[mid] < target) {
                start = mid + 1;
            } else if (sortedArray[mid] > target) {
                end = mid;
            }
        }
        return -1;
    }

    // There's overhead involved with method calls
    public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int target) {
        if (start >= end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (sortedArray[mid] == target) {
            return mid;
        } else if (sortedArray[mid] < target) {
            return recursiveBinarySearch(sortedArray, mid + 1, end, target);
        } else {
            return recursiveBinarySearch(sortedArray, start, mid, target);
        }
    }
}
