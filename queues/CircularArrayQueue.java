import model.Employee;

import java.util.NoSuchElementException;

public class CircularArrayQueue {

    // Queue but can be wrapped to take empty spaces on the front of array

    private Employee[] queue;
    private int front;
    private int back;

    public CircularArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (size() == queue.length - 1) {
            int size = size();
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            // if queue has been wrapped then copy
            if (back < front) {
                System.arraycopy(queue, 0, newArray, queue.length - front, back);
            }
            queue = newArray;
            front = 0;
            back = size;
        }

        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0; // if it's no spaces for incrementing back, set back to start of array
        }
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
        } else if (front == queue.length) {
            front = 0;
        }
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int j = 0; j < back; j++) {
                System.out.println(queue[j]);
            }
        }
    }
}
