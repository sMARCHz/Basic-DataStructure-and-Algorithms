import model.Employee;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue;
    private int front; // point to startIndex of queue (inclusive)
    private int back; // point to end (exclusive: endIndex+1)

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        // resize array if it's full
        // !! if capacity = 5, front = 4, back = 5, so it'll resize the array and takes more memory. but actual employee in the array is only 1,
        // so the spaces in front of the front index are empty and aren't worth for increasing memory just for store few values. (Go to circular queues)
        if (back == queue.length) {
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[back] = employee;
        back++;
    }

    public Employee remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if (isEmpty()) {
            front = 0;
            back = 0;
        }
        return employee;
    }

    // JDK queue's peek method doesn't throw exception
    public Employee peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
