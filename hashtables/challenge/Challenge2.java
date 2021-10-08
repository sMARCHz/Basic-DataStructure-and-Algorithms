package challenge;

import model.Employee;

import java.util.*;

public class Challenge2 {

    // Challenge#2
    // Remove duplicate items in the linkedList (employees)
    // Shouldn't have any fields to track where things are in the LinkedList -> Must use hashMap instead

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(System.out::println);

        HashMap<Integer, Employee> employeeTable = new HashMap<>();
        List<Employee> removedEmployee = new ArrayList<>();
        for (Employee employee : employees) {
            if (employeeTable.containsKey(employee.getId())) {
                removedEmployee.add(employee);
                // unable to remove here because iterator will throw exception
            } else {
                employeeTable.put(employee.getId(), employee);
            }
        }
        for (Employee employee : removedEmployee) {
            employees.remove(employee);
        }
        System.out.println("-----------------------------");
        employees.forEach(System.out::println);
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }
}
