/*
 *  Composite Pattern
 */

import java.util.*;
import java.io.*;
import java.lang.*;

// Component interface representing both leaf and composite objects
class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    // Constructor
    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        subordinates = new ArrayList<Employee>();
    }

    // Method to add a subordinate
    public void add(Employee e) {
        subordinates.add(e);
    }

    // Method to remove a subordinate
    public void remove(Employee e) {
        subordinates.remove(e);
    }

    // Method to get the list of subordinates
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    // Method to display employee details
    public String toString() {
        return ("Employee: [Name: " + name + ", Dept: " + dept + ", Salary: " + salary + "]");
    }
}

// Client class to demonstrate the Composite Pattern
public class CompositePattern {
    public static void main(String[] args) {

        // Creating employee instances
        Employee CEO = new Employee("Arkapratim", "CEO", 30000);
        Employee headSales = new Employee("Ramu", "Head Sales", 20000);
        Employee headMarketing = new Employee("Shyam", "Head Marketing", 20000);
        Employee clerk1 = new Employee("Jadu", "Marketing", 10000);
        Employee clerk2 = new Employee("Modhu", "Marketing", 10000);
        Employee salesExecutive1 = new Employee("Shyamal", "Sales", 10000);
        Employee salesExecutive2 = new Employee("Jagjit", "Sales", 10000);

        // Building the employee hierarchy
        CEO.add(headSales);
        CEO.add(headMarketing);
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        // Printing the employee hierarchy
        System.out.println(CEO);

        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);

            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
