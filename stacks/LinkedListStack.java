import model.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListStack {

    // O(1) for insert and delete data
    // Ideal backing data structure, but take more memory than array.
    // LinkedList implements Deque, so it already contains push(), pop(), peek()

    private LinkedList<Employee> stack;

    public LinkedListStack() {
        stack = new LinkedList<>();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Employee> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
