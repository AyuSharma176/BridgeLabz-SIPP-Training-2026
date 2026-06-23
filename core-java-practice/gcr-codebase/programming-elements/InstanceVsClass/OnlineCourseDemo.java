// Instance vs. Class Variables and Methods - Problem 2: Online Course Management
import java.util.Scanner;

class Course {
    // Instance variables (unique to each course)
    private String courseName;
    private int duration;       // in hours
    private double fee;

    // Class variable - shared by all Course objects
    private static String instituteName = "Tech Learning Academy";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration   = duration;
        this.fee        = fee;
    }

    // Getters and Setters
    public String getCourseName()       { return courseName; }
    public int getDuration()            { return duration; }
    public double getFee()              { return fee; }
    public void setCourseName(String n) { this.courseName = n; }
    public void setDuration(int d)      { this.duration = d; }
    public void setFee(double f)        { this.fee = f; }

    // Instance method - displays THIS course's details
    public void displayCourseDetails() {
        System.out.println("Institute    : " + instituteName);
        System.out.println("Course Name  : " + courseName);
        System.out.println("Duration     : " + duration + " hours");
        System.out.printf("Fee          : Rs. %.2f%n", fee);
    }

    // Class (static) method - updates the shared institute name for ALL courses
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    // Getter for institute name
    public static String getInstituteName() {
        return instituteName;
    }
}

class OnlineCourseDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many courses do you want to create? ");
        int count = sc.nextInt();
        sc.nextLine();

        Course[] courses = new Course[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Course " + (i + 1) + ":");
            System.out.print("Course Name : ");
            String name = sc.nextLine();
            System.out.print("Duration (hours): ");
            int duration = sc.nextInt();
            System.out.print("Fee        : ");
            double fee = sc.nextDouble();
            sc.nextLine();
            courses[i] = new Course(name, duration, fee);
        }

        System.out.println("\n--- All Course Details (Instance Method) ---");
        for (Course c : courses) {
            c.displayCourseDetails();
            System.out.println();
        }

        // Update institute name using class method - affects all courses
        System.out.print("Enter new institute name: ");
        String newName = sc.nextLine();
        Course.updateInstituteName(newName);

        System.out.println("\n--- Course Details After Institute Name Update ---");
        for (Course c : courses) {
            c.displayCourseDetails();
            System.out.println();
        }

        sc.close();
    }
}
