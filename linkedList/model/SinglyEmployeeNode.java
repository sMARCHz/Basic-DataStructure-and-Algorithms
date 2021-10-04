package model;

public class SinglyEmployeeNode {
    private Employee employee;
    private SinglyEmployeeNode next;

    public SinglyEmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SinglyEmployeeNode getNext() {
        return next;
    }

    public void setNext(SinglyEmployeeNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
