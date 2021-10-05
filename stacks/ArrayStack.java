import model.Employee;

import java.util.EmptyStackException;

public class ArrayStack {

    // O(n) for insert(push) the data because it needs to resize the array.
    // O(1) for delete(pop) the data. O(n) if implements resizing.
    // LinkedList is ideal for stack but if your memory is tight, or you know maximum number of items you can use array instead of it.

    private Employee[] stack;
    private int top; // point to right-most side of array (exclusive)

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        // resize array if it's full
        if (top == stack.length) {
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = employee;
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
