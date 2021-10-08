import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    // O(n)
    // Stable or unstable of algorithms is depended on sorting algorithms. (Insertion sort is popular to use for bucket sort)
    // Make assumption about the data, like radix sort and stable counting sort
    // Hash data then store data in the bucket at the index which is equal to hashed data.
    // Then sort the bucket in each index and then copy to origin array

    public static void main(String[] args) {
        int[] array = {54, 46, 83, 66, 95, 92, 43};
        bucketSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void bucketSort(int[] array) {
        List<Integer>[] buckets = new List[10]; // parent interface
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>(); // can change to linkedList
        }
        for (int i : array) {
            buckets[hash(i)].add(i);
        }
        for (List bucket : buckets) {
            Collections.sort(bucket);
        }
        int j = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                array[j++] = value;
            }
        }
    }

    private static int hash(int value) {
        return (value / 10) % 10;
    }
}
