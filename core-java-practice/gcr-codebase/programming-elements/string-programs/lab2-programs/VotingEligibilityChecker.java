// Program 8: Check voting eligibility for students based on age
import java.util.Scanner;

class VotingEligibilityChecker {

    // Method to generate random 2-digit ages for n students
    // Returns a 1D int array of ages
    public static int[] generateStudentAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            // Generate random age between 10 and 25 (2-digit)
            ages[i] = (int) (Math.random() * 16) + 10;
        }
        return ages;
    }

    // Method to return a 2D String array of [age, canVote]
    // Validates for negative age; true if age >= 18
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] eligibilityArray = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            eligibilityArray[i][0] = String.valueOf(age);

            if (age < 0) {
                // Invalid age — cannot vote
                eligibilityArray[i][1] = "Invalid Age";
            } else if (age >= 18) {
                eligibilityArray[i][1] = "true";  // Can vote
            } else {
                eligibilityArray[i][1] = "false"; // Cannot vote
            }
        }
        return eligibilityArray;
    }

    // Method to display the 2D eligibility array in a tabular format
    public static void displayEligibilityTable(String[][] eligibilityArray) {
        System.out.println("\n--- Student Voting Eligibility Table ---");
        System.out.printf("%-10s %-10s %-15s%n", "Student", "Age", "Can Vote?");
        System.out.println("--------------------------------------");
        for (int i = 0; i < eligibilityArray.length; i++) {
            String age = eligibilityArray[i][0];
            String canVote = eligibilityArray[i][1];
            String status;
            if (canVote.equals("true")) {
                status = "Yes";
            } else if (canVote.equals("false")) {
                status = "No";
            } else {
                status = canVote;
            }
            System.out.printf("%-10d %-10s %-15s%n", (i + 1), age, status);
        }
    }

    public static void main(String[] args) {
        // Take input for number of students
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        // Generate random ages for students
        int[] studentAges = generateStudentAges(numberOfStudents);

        // Check voting eligibility
        String[][] eligibilityArray = checkVotingEligibility(studentAges);

        // Display results in tabular format
        displayEligibilityTable(eligibilityArray);

        sc.close();
    }
}
