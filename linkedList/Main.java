import model.Employee;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee marySmith = new Employee("Mary", "Smith", 2);
        Employee georgeBrown = new Employee("George", "Brown", 3);
        Employee nathanWilliams = new Employee("Nathan", "Williams", 4);

        // SinglyLinkedList
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addToFront(johnDoe);
        singlyLinkedList.addToFront(marySmith);
        singlyLinkedList.addToFront(georgeBrown);
        singlyLinkedList.printList();
        singlyLinkedList.removeFront();
        singlyLinkedList.printList();

        // DoublyLinkedList
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addToFront(johnDoe);
        doublyLinkedList.addToFront(marySmith);
        doublyLinkedList.addToFront(georgeBrown);
        doublyLinkedList.printList();
        doublyLinkedList.addToTail(nathanWilliams);
        doublyLinkedList.printList();
        doublyLinkedList.removeFront();
        doublyLinkedList.printList();
        doublyLinkedList.removeEnd();
        doublyLinkedList.printList();

        // JDK LinkedList - use Doubly LinkedList
        LinkedList<Employee> jdkLinkedList = new LinkedList<>();
        jdkLinkedList.addFirst(johnDoe);
        jdkLinkedList.add(marySmith);
        jdkLinkedList.add(georgeBrown);
        System.out.print("HEAD");
        // Print#1
        ListIterator<Employee> iterator = jdkLinkedList.listIterator();
        while (iterator.hasNext()) {
            System.out.print(" <=> ");
            System.out.print(iterator.next());
        }
        // Print#2
        for (Employee employee : jdkLinkedList) {
            System.out.print(" <=> ");
            System.out.print(employee);
        }
        System.out.printf(" <=> TAIL (Size: %d)%n", jdkLinkedList.size());
    }
}
