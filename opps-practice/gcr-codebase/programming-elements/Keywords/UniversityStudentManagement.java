// Program 5: University Student Management
// Demonstrates: static, this, final, instanceof
import java.util.Scanner;

class Student {

    // STATIC: university name shared across all Student objects
    private static String universityName = "Apex University";
    private static int totalStudents = 0;

    // FINAL: rollNumber uniquely identifies a student and cannot change
    private final String rollNumber;

    // Instance variables
    private String name;
    private char grade;

    // Constructor - uses THIS to resolve ambiguity
    public Student(String rollNumber, String name, char grade) {
        this.rollNumber = rollNumber;   // 'this' resolves parameter vs attribute
        this.name       = name;
        this.grade      = grade;
        totalStudents++;                // Increment shared counter
    }

    // Getters
    public String getRollNumber() { return rollNumber; }
    public String getName()       { return name; }
    public char getGrade()        { return grade; }

    // Setters (rollNumber is final — no setter for it)
    public void setName(String name) { this.name = name; }

    // Update grade — validated through instanceof before calling (shown in main)
    public void updateGrade(char newGrade) {
        char upperGrade = Character.toUpperCase(newGrade);
        if (upperGrade == 'A' || upperGrade == 'B' || upperGrade == 'C'
                || upperGrade == 'D' || upperGrade == 'F') {
            this.grade = upperGrade;
            System.out.println("Grade updated to '" + grade + "' for " + name);
        } else {
            System.out.println("Invalid grade! Use A, B, C, D, or F.");
        }
    }

    // STATIC methods: accessed on the class, not an object
    public static void displayTotalStudents() {
        System.out.println("University     : " + universityName);
        System.out.println("Total Students : " + totalStudents);
    }

    public static void setUniversityName(String name) { universityName = name; }

    // Display student details
    public void displayStudentDetails() {
        System.out.println("University  : " + universityName);
        System.out.println("Roll Number : " + rollNumber);   // final — cannot change
        System.out.println("Name        : " + name);
        System.out.println("Grade       : " + grade);
    }
}

class UniversityStudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students to enrol? ");
        int count = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Roll Number : ");
            String roll = sc.nextLine();
            System.out.print("Name        : ");
            String name = sc.nextLine();
            System.out.print("Grade (A/B/C/D/F): ");
            char grade = sc.next().charAt(0);
            sc.nextLine();
            students[i] = new Student(roll, name, grade);
        }

        // STATIC method call
        System.out.println("\n--- University Summary (Static Method) ---");
        Student.displayTotalStudents();

        // INSTANCEOF check before displaying or updating
        System.out.println("\n--- Student Details (instanceof check) ---");
        Object[] objects = students;
        for (Object obj : objects) {
            if (obj instanceof Student) {             // INSTANCEOF verification
                Student s = (Student) obj;
                s.displayStudentDetails();
                System.out.println();
            }
        }

        // Update grade for first student — only after instanceof check
        if (students.length > 0) {
            Object first = students[0];
            System.out.print("Enter new grade for Student 1 (A/B/C/D/F): ");
            char newGrade = sc.next().charAt(0);
            if (first instanceof Student) {          // INSTANCEOF before update
                ((Student) first).updateGrade(newGrade);
                ((Student) first).displayStudentDetails();
            }
        }

        System.out.println("\nNote: 'rollNumber' is declared 'final' — it cannot be changed after creation.");

        sc.close();
    }
}
