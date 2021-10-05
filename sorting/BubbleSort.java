public class BubbleSort {

    // O(n^2)
    // Stable
    // Bubble large value to the right
    public static void main(String[] args) {
        int[] array = {20, -1, 59, 48, 0, -22};
        bubbleSort(array);

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int j = 0; j < lastUnsortedIndex; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
