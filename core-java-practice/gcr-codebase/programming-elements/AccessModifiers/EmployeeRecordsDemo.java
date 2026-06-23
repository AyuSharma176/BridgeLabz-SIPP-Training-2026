// Access Modifiers - Problem 4: Employee Records
import java.util.Scanner;

// Base class Employee
class Employee {
    public int employeeID;         // public - accessible everywhere
    protected String department;   // protected - accessible in subclass
    private double salary;         // private - only within this class

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary     = salary;
    }

    // Public getter for private salary
    public double getSalary() {
        return salary;
    }

    // Public method to modify salary (controlled access to private field)
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            System.out.printf("Salary updated to: Rs. %.2f%n", salary);
        } else {
            System.out.println("Salary must be a positive value!");
        }
    }

    // Give a salary raise by a percentage
    public void applyRaise(double raisePercent) {
        double raise = salary * (raisePercent / 100);
        salary += raise;
        System.out.printf("Raise of %.1f%% applied. New salary: Rs. %.2f%n", raisePercent, salary);
    }

    // Display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID  : " + employeeID);
        System.out.println("Department   : " + department);
        System.out.printf("Salary       : Rs. %.2f%n", salary);
    }
}

// Subclass Manager demonstrating access to public and protected members
class Manager extends Employee {
    private String managerLevel;    // e.g., Junior Manager, Senior Manager
    private int teamSize;

    public Manager(int employeeID, String department, double salary,
                   String managerLevel, int teamSize) {
        super(employeeID, department, salary);
        this.managerLevel = managerLevel;
        this.teamSize     = teamSize;
    }

    // Can access public employeeID and protected department directly
    public void displayManagerDetails() {
        System.out.println("Employee ID    : " + employeeID);     // public - accessible
        System.out.println("Department     : " + department);     // protected - accessible
        System.out.printf("Salary         : Rs. %.2f%n", getSalary()); // private via getter
        System.out.println("Manager Level  : " + managerLevel);
        System.out.println("Team Size      : " + teamSize + " members");
    }
}

class EmployeeRecordsDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a base employee
        System.out.println("Enter Employee Details:");
        System.out.print("Employee ID  : ");
        int empID = sc.nextInt();
        sc.nextLine();
        System.out.print("Department   : ");
        String dept = sc.nextLine();
        System.out.print("Salary       : ");
        double salary = sc.nextDouble();

        Employee employee = new Employee(empID, dept, salary);
        System.out.println("\n--- Employee Details ---");
        employee.displayEmployeeDetails();

        System.out.print("\nEnter new salary: Rs. ");
        employee.setSalary(sc.nextDouble());

        System.out.print("Enter raise percentage: ");
        employee.applyRaise(sc.nextDouble());
        sc.nextLine();

        // Create a manager (subclass)
        System.out.println("\nEnter Manager Details:");
        System.out.print("Employee ID    : ");
        int mgrID = sc.nextInt();
        sc.nextLine();
        System.out.print("Department     : ");
        String mgrDept = sc.nextLine();
        System.out.print("Salary         : ");
        double mgrSalary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Manager Level (Junior/Senior): ");
        String mgrLevel = sc.nextLine();
        System.out.print("Team Size      : ");
        int teamSize = sc.nextInt();

        Manager manager = new Manager(mgrID, mgrDept, mgrSalary, mgrLevel, teamSize);
        System.out.println("\n--- Manager Details (Subclass) ---");
        manager.displayManagerDetails();

        sc.close();
    }
}
