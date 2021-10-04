package model;

public class DoublyEmployeeNode {
    private Employee employee;
    private DoublyEmployeeNode next;
    private DoublyEmployeeNode previous;

    public DoublyEmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public DoublyEmployeeNode getNext() {
        return next;
    }

    public void setNext(DoublyEmployeeNode next) {
        this.next = next;
    }

    public DoublyEmployeeNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyEmployeeNode previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
