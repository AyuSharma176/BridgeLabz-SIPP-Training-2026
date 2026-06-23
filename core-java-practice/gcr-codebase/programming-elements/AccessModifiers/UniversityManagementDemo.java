// Access Modifiers - Problem 1: University Management System
import java.util.Scanner;

// Base class Student
class Student {
    public int rollNumber;        // public - accessible everywhere
    protected String name;        // protected - accessible in subclass
    private double cgpa;          // private - only accessible within this class

    // Constructor
    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name       = name;
        this.cgpa       = cgpa;
    }

    // Public getter and setter for private cgpa
    public double getCGPA() {
        return cgpa;
    }

    public void setCGPA(double cgpa) {
        if (cgpa >= 0.0 && cgpa <= 10.0) {
            this.cgpa = cgpa;
            System.out.println("CGPA updated successfully to " + cgpa);
        } else {
            System.out.println("Invalid CGPA! Must be between 0.0 and 10.0");
        }
    }

    // Display base student details
    public void displayStudentDetails() {
        System.out.println("Roll Number : " + rollNumber);  // public
        System.out.println("Name        : " + name);        // protected (accessible here)
        System.out.println("CGPA        : " + cgpa);        // private (accessible here via getter)
    }
}

// Subclass demonstrating protected access
class PostgraduateStudent extends Student {
    private String researchTopic;

    // Constructor — calls parent constructor using super()
    public PostgraduateStudent(int rollNumber, String name, double cgpa, String researchTopic) {
        super(rollNumber, name, cgpa);
        this.researchTopic = researchTopic;
    }

    // Subclass can access protected 'name' and public 'rollNumber' directly
    public void displayPGDetails() {
        System.out.println("Roll Number    : " + rollNumber);    // public — accessible
        System.out.println("Name           : " + name);          // protected — accessible in subclass
        System.out.println("CGPA           : " + getCGPA());     // private — accessed via public getter
        System.out.println("Research Topic : " + researchTopic);
    }
}

class UniversityManagementDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create undergraduate student
        System.out.println("Enter Undergraduate Student Details:");
        System.out.print("Roll Number : ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Name        : ");
        String name = sc.nextLine();
        System.out.print("CGPA (0-10) : ");
        double cgpa = sc.nextDouble();
        sc.nextLine();

        Student student = new Student(roll, name, cgpa);
        System.out.println("\n--- Student Details ---");
        student.displayStudentDetails();

        System.out.print("\nEnter new CGPA to update: ");
        double newCgpa = sc.nextDouble();
        student.setCGPA(newCgpa);

        // Create postgraduate student
        System.out.println("\nEnter Postgraduate Student Details:");
        System.out.print("Roll Number    : ");
        int pgRoll = sc.nextInt();
        sc.nextLine();
        System.out.print("Name           : ");
        String pgName = sc.nextLine();
        System.out.print("CGPA (0-10)    : ");
        double pgCgpa = sc.nextDouble();
        sc.nextLine();
        System.out.print("Research Topic : ");
        String topic = sc.nextLine();

        PostgraduateStudent pgStudent = new PostgraduateStudent(pgRoll, pgName, pgCgpa, topic);
        System.out.println("\n--- Postgraduate Student Details ---");
        pgStudent.displayPGDetails();

        sc.close();
    }
}
