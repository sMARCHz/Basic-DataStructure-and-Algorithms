import model.Employee;
import model.SinglyEmployeeNode;

public class SinglyLinkedList {
    private SinglyEmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        SinglyEmployeeNode node = new SinglyEmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public SinglyEmployeeNode removeFront() {
        if (isEmpty()) {
            return null;
        }
        SinglyEmployeeNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void printList() {
        SinglyEmployeeNode current = head;
        System.out.print("HEAD");
        while (current != null) {
            System.out.print(" -> ");
            System.out.print(current);
            current = current.getNext();
        }
        System.out.printf(" -> NULL (Size: %d)%n", size);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
