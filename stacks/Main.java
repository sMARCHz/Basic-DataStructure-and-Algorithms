import model.Employee;

public class Main {

    // Stack is an abstract data type not an actual data structure, so it needs backing data structure for it. LinkedList is ideal.
    // Last In - First Out
    public static void main(String[] args) {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee marySmith = new Employee("Mary", "Smith", 2);
        Employee georgeBrown = new Employee("George", "Brown", 3);
        Employee nathanWilliams = new Employee("Nathan", "Williams", 4);

        // Stack backing by array
        ArrayStack arrayStack = new ArrayStack(5);
        System.out.println("Push 3 employees");
        arrayStack.push(johnDoe);
        arrayStack.push(marySmith);
        arrayStack.push(georgeBrown);
        arrayStack.printStack();
        System.out.println("\nPopped: " + arrayStack.pop());
        arrayStack.printStack();
        System.out.println("\nPush 1 employee");
        arrayStack.push(nathanWilliams);
        arrayStack.printStack();
        System.out.println("\nPeek: " + arrayStack.peek());

        // Stack backing by LinkedList
        LinkedListStack linkedListStack = new LinkedListStack();
        System.out.println("Push 3 employees");
        linkedListStack.push(johnDoe);
        linkedListStack.push(marySmith);
        linkedListStack.push(georgeBrown);
        linkedListStack.printStack();
        System.out.println("\nPopped: " + linkedListStack.pop());
        linkedListStack.printStack();
        System.out.println("\nPush 1 employee");
        linkedListStack.push(nathanWilliams);
        linkedListStack.printStack();
        System.out.println("\nPeek: " + linkedListStack.peek());
    }
}
