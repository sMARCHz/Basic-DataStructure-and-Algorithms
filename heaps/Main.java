import java.util.PriorityQueue;

public class Main {

    // Heaps is abstract data type
    // Heaps is complete binary tree (every level is fulled except last level)
    // This heaps isn't the same as memory heap
    // Usually back by array
    // Heaps has 2 type the minHeap and maxHeap. MinHeap keeps the parent's value smaller than children. MaxHeap keeps the parent's value larger.
    // The maximum or minimum value is always be at the root of the tree (get max or min is very easy)
    // Heapify - process of converting a binary tree into a heap (often done after insert or delete)

    // left child = 2i + 1
    // right child = 2i + 2
    // parent = floor((i-1)/2)
    // where i = an index of the subtree, it works only complete binary tree

    public static void main(String[] args) {
        // Normal Heap
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.printHeap();
        heap.delete(5);
        heap.printHeap();
        System.out.println("Peek: " + heap.peek());
        heap.delete(0);
        heap.printHeap();
        System.out.println("Peek: " + heap.peek());
        System.out.println();
        heap.sort();
        heap.printHeap();

        // Priority Queue (The highest priority at root)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);
        System.out.println("Peek: " + pq.peek());
        System.out.println("Remove: " + pq.remove()); // remove the highest priority (minimum value)
        System.out.println("Peek: " + pq.peek());
        System.out.println("Poll: " + pq.poll()); // same as remove without parameter
        System.out.println("Peek: " + pq.peek());
        System.out.println("Remove: " + pq.remove(54));
        System.out.println("Peek: " + pq.peek());
        pq.add(-1);
        System.out.println("Peek: " + pq.peek());
        System.out.println();

        Object[] ints = pq.toArray();
        for (Object num : ints) {
            System.out.print(num);
            System.out.print(", ");
        }
    }
}
