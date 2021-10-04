import model.DoublyEmployeeNode;
import model.Employee;

public class DoublyLinkedList {
    private DoublyEmployeeNode head;
    private DoublyEmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {
        DoublyEmployeeNode node = new DoublyEmployeeNode(employee);
        node.setNext(head);
        if (isEmpty()) {
            tail = node;
        } else {
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    public void addToTail(Employee employee) {
        DoublyEmployeeNode node = new DoublyEmployeeNode(employee);
        node.setPrevious(tail);
        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public DoublyEmployeeNode removeFront() {
        if (isEmpty()) {
            return null;
        }
        DoublyEmployeeNode removedNode = head;
        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public DoublyEmployeeNode removeEnd() {
        if (isEmpty()) {
            return null;
        }
        DoublyEmployeeNode removedNode = tail;
        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        DoublyEmployeeNode current = head;
        System.out.print("HEAD");
        while (current != null) {
            System.out.print(" <=> ");
            System.out.print(current);
            current = current.getNext();
        }
        System.out.printf(" <=> TAIL (Size: %d)%n", size);
    }
}
