import java.util.Scanner;

/**
 * Console-driven application that lets an online learning platform mark
 * student attendance for multiple subjects, view per-subject attendance
 * lists, and see attendance totals, while automatically preventing
 * duplicate attendance entries.
 */
public class AttendanceApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceTracker tracker = new AttendanceTracker();

        boolean running = true;

        System.out.println("=====================================");
        System.out.println(" SMART CLASSROOM ATTENDANCE TRACKER");
        System.out.println("=====================================");

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter subject name: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String student = scanner.nextLine();
                    tracker.markAttendance(subject, student);
                    break;

                case "2":
                    tracker.displayAllAttendance();
                    break;

                case "3":
                    System.out.print("Enter subject name to view: ");
                    String subjectToView = scanner.nextLine();
                    tracker.displayAttendanceForSubject(subjectToView);
                    break;

                case "4":
                    System.out.println("\nTotal attendance entries across all subjects: "
                            + tracker.getTotalAttendanceAcrossSubjects());
                    break;

                case "5":
                    running = false;
                    System.out.println("Exiting Smart Classroom Attendance Tracker. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 5.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n------ MENU ------");
        System.out.println("1. Mark attendance for a student");
        System.out.println("2. Display attendance for all subjects");
        System.out.println("3. Display attendance for a specific subject");
        System.out.println("4. Show total attendance across all subjects");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}
