// Program 3: Employee Management System
// Demonstrates: static, this, final, instanceof
import java.util.Scanner;

class Employee {

    // STATIC: shared across all Employee objects
    private static String companyName = "Innovate Tech Solutions";
    private static int totalEmployees = 0;

    // FINAL: employee id cannot be modified after assignment
    private final int id;

    // Instance variables
    private String name;
    private String designation;
    private double salary;

    // Constructor - uses THIS to resolve ambiguity
    public Employee(int id, String name, String designation, double salary) {
        this.id          = id;           // 'this' resolves ambiguity
        this.name        = name;
        this.designation = designation;
        this.salary      = salary;
        totalEmployees++;               // Increment shared counter
    }

    // Getters
    public int getId()              { return id; }
    public String getName()         { return name; }
    public String getDesignation()  { return designation; }
    public double getSalary()       { return salary; }

    // Setters (id is final — no setter for it)
    public void setName(String name)              { this.name = name; }
    public void setDesignation(String designation){ this.designation = designation; }
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be positive!");
        }
    }

    // Apply percentage raise to salary
    public void applyRaise(double raisePercent) {
        double raise = salary * (raisePercent / 100);
        salary += raise;
        System.out.printf("Raise of %.1f%% applied. New Salary: Rs. %.2f%n", raisePercent, salary);
    }

    // STATIC methods: accessed via class, not object
    public static void displayTotalEmployees() {
        System.out.println("Company        : " + companyName);
        System.out.println("Total Employees: " + totalEmployees);
    }

    public static void setCompanyName(String name) { companyName = name; }

    // Display employee details
    public void displayEmployeeDetails() {
        System.out.println("Company     : " + companyName);
        System.out.println("Employee ID : " + id);           // final — cannot change
        System.out.println("Name        : " + name);
        System.out.println("Designation : " + designation);
        System.out.printf("Salary      : Rs. %.2f%n", salary);
    }
}

class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees to register? ");
        int count = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("Employee ID  : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name         : ");
            String name = sc.nextLine();
            System.out.print("Designation  : ");
            String designation = sc.nextLine();
            System.out.print("Salary       : ");
            double salary = sc.nextDouble();
            sc.nextLine();
            employees[i] = new Employee(id, name, designation, salary);
        }

        // STATIC method call
        System.out.println("\n--- Company Summary (Static Method) ---");
        Employee.displayTotalEmployees();

        // INSTANCEOF check before displaying details
        System.out.println("\n--- Employee Details (instanceof check) ---");
        Object[] objects = employees;
        for (Object obj : objects) {
            if (obj instanceof Employee) {           // INSTANCEOF verification
                Employee emp = (Employee) obj;
                emp.displayEmployeeDetails();
                System.out.println();
            }
        }

        // Apply raise to first employee
        if (employees.length > 0) {
            System.out.print("Enter raise percentage for Employee 1: ");
            double raisePercent = sc.nextDouble();
            employees[0].applyRaise(raisePercent);
        }

        System.out.println("\nNote: 'id' is declared 'final' — employee ID cannot be changed after creation.");

        sc.close();
    }
}
