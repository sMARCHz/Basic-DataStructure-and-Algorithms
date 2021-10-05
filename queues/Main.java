import model.Employee;

public class Main {

    // Queues is an abstract data type
    // First In - First Out
    // LinkedList is perfect for queues
    public static void main(String[] args) {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee marySmith = new Employee("Mary", "Smith", 2);
        Employee georgeBrown = new Employee("George", "Brown", 3);
        Employee nathanWilliams = new Employee("Nathan", "Williams", 4);
        Employee harryPotter = new Employee("Harry", "Potter", 5);
        Employee tonyStark = new Employee("Tony", "Stark", 6);
        Employee josephJoestar = new Employee("Joseph", "Joestar", 7);

        // Queue backing by array
        ArrayQueue arrayQueue = new ArrayQueue(5);
        System.out.println("Push 3 employees");
        arrayQueue.add(johnDoe);
        arrayQueue.add(marySmith);
        arrayQueue.add(georgeBrown);
        arrayQueue.printQueue();
        System.out.println("\nRemoved: " + arrayQueue.remove());
        arrayQueue.printQueue();
        System.out.println("\nPush 1 employee");
        arrayQueue.add(nathanWilliams);
        System.out.println("\nPeek: " + arrayQueue.peek());

        // Circular Queue backing by array
        CircularArrayQueue circularArrayQueue = new CircularArrayQueue(5);
        System.out.println("Push 3 employees");
        circularArrayQueue.add(johnDoe);
        circularArrayQueue.add(marySmith);
        circularArrayQueue.add(georgeBrown);
        circularArrayQueue.printQueue();
        System.out.println("\nRemoved: " + circularArrayQueue.remove());
        circularArrayQueue.printQueue();
        System.out.println("\nPush 1 employee");
        circularArrayQueue.add(nathanWilliams);
        circularArrayQueue.printQueue();
        System.out.println("\nRemoved: " + circularArrayQueue.remove());
        circularArrayQueue.printQueue();
        System.out.println("\nPush 3 employees");
        circularArrayQueue.add(harryPotter);
        circularArrayQueue.add(tonyStark);
        circularArrayQueue.add(josephJoestar);
        circularArrayQueue.printQueue();
    }
}
