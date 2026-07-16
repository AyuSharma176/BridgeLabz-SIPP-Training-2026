// Program 10: Student scorecard - marks, percentage, and grade for PCM subjects
import java.util.Scanner;

class StudentScorecard {

    // Grade table:
    // Percentage >= 90  → Grade A+
    // Percentage >= 80  → Grade A
    // Percentage >= 70  → Grade B+
    // Percentage >= 60  → Grade B
    // Percentage >= 50  → Grade C
    // Percentage >= 40  → Grade D
    // Percentage <  40  → Grade F (Fail)

    // Method to generate random 2-digit scores for PCM for n students
    // Returns a 2D int array: [studentIndex][physics, chemistry, maths]
    public static int[][] generateScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = (int) (Math.random() * 51) + 50; // Physics: 50–100
            scores[i][1] = (int) (Math.random() * 51) + 50; // Chemistry: 50–100
            scores[i][2] = (int) (Math.random() * 51) + 50; // Maths: 50–100
        }
        return scores;
    }

    // Method to calculate total, average, and percentage for each student
    // Returns 2D String array: [studentIndex][total, average, percentage]
    // Values are rounded to 2 decimal places using Math.round()
    public static String[][] calculateTotalAndPercentage(int[][] scores) {
        String[][] results = new String[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = Math.round((total / 3.0) * 100.0) / 100.0;
            double percentage = Math.round((total / 300.0) * 10000.0) / 100.0;

            results[i][0] = String.valueOf(total);
            results[i][1] = String.valueOf(average);
            results[i][2] = String.valueOf(percentage);
        }
        return results;
    }

    // Method to calculate grade based on percentage
    // Returns a 2D String array: [studentIndex][grade]
    public static String[][] calculateGrades(String[][] results) {
        String[][] grades = new String[results.length][1];
        for (int i = 0; i < results.length; i++) {
            double percentage = Double.parseDouble(results[i][2]);
            if (percentage >= 90) {
                grades[i][0] = "A+";
            } else if (percentage >= 80) {
                grades[i][0] = "A";
            } else if (percentage >= 70) {
                grades[i][0] = "B+";
            } else if (percentage >= 60) {
                grades[i][0] = "B";
            } else if (percentage >= 50) {
                grades[i][0] = "C";
            } else if (percentage >= 40) {
                grades[i][0] = "D";
            } else {
                grades[i][0] = "F";
            }
        }
        return grades;
    }

    // Method to display the complete scorecard in a tabular format
    public static void displayScorecard(int[][] scores, String[][] results, String[][] grades) {
        System.out.println("\n=============================================================================================");
        System.out.println("                              STUDENT SCORECARD");
        System.out.println("=============================================================================================");
        System.out.printf("%-8s %-10s %-12s %-8s %-8s %-10s %-12s %-6s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-8d %-10d %-12d %-8d %-8s %-10s %-12s %-6s%n",
                    (i + 1),
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    results[i][0],
                    results[i][1],
                    results[i][2] + "%",
                    grades[i][0]);
        }

        System.out.println("=============================================================================================");
        System.out.println("\nGrade Scale: A+ (>=90%) | A (>=80%) | B+ (>=70%) | B (>=60%) | C (>=50%) | D (>=40%) | F (<40%)");
    }

    public static void main(String[] args) {
        // Take input for number of students
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        // Generate random PCM scores
        int[][] scores = generateScores(numberOfStudents);

        // Calculate total, average, and percentage
        String[][] results = calculateTotalAndPercentage(scores);

        // Calculate grades
        String[][] grades = calculateGrades(results);

        // Display the complete scorecard
        displayScorecard(scores, results, grades);

        sc.close();
    }
}
