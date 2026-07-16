// RajResultGenerator - Coaching centre result system for 5 subjects
// Concepts: Variables, Scanner, for-loop, Average, Switch-case for grades
import java.util.Scanner;

class RajResultGenerator {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Define the number of subjects and maximum marks as constant variables
      int numberOfSubjects = 5;
      double maxMarksPerSubject = 100.0;

      // Define subject names as a String array
      String[] subjectNames = {"Mathematics", "Science", "English", "History", "Computer Science"};

      // Define an array to store marks for each subject
      double[] marks = new double[numberOfSubjects];

      // Get student name from user
      System.out.print("Enter Student Name: ");
      String studentName = input.next();

      System.out.println("\nEnter marks for " + studentName + " (out of " + (int)maxMarksPerSubject + "):");

      // Use for-loop to iterate over each subject and take marks as input
      for (int i = 0; i < marks.length; i++) {
         System.out.print("  " + subjectNames[i] + ": ");
         marks[i] = input.nextDouble();

         // Validate marks are between 0 and maxMarksPerSubject
         if (marks[i] < 0 || marks[i] > maxMarksPerSubject) {
            System.out.println("  Invalid marks! Must be between 0 and " + (int)maxMarksPerSubject + ". Re-enter.");
            i--; // Decrement index to re-enter this subject's marks
            continue;
         }
      }

      // Calculate the total marks using a for-loop
      double totalMarks = 0;
      for (int i = 0; i < marks.length; i++) {
         totalMarks += marks[i];
      }

      // Calculate average marks
      double averageMarks = totalMarks / numberOfSubjects;

      // Calculate percentage
      double percentage = (totalMarks / (numberOfSubjects * maxMarksPerSubject)) * 100;

      // Determine grade using switch on rounded percentage bracket
      // Convert percentage to a bracket integer for switch (e.g., 85 -> 8)
      int gradeBracket = (int) percentage / 10;
      String grade;

      // Assign grade using switch-case based on grade bracket
      switch (gradeBracket) {
         case 10:
         case 9:
            // 90% and above => A+
            grade = "A+";
            break;
         case 8:
            // 80-89% => A
            grade = "A";
            break;
         case 7:
            // 70-79% => B
            grade = "B";
            break;
         case 6:
            // 60-69% => C
            grade = "C";
            break;
         case 5:
            // 50-59% => D
            grade = "D";
            break;
         default:
            // Below 50% => F (Fail)
            grade = "F";
            break;
      }

      // Determine pass/fail status
      boolean isPassed = percentage >= 50.0;
      String resultStatus = isPassed ? "PASSED" : "FAILED";

      // Display the full result report
      System.out.println("\n========================================");
      System.out.println("       RAJ'S COACHING CENTRE RESULT     ");
      System.out.println("========================================");
      System.out.println("Student Name : " + studentName);
      System.out.println("----------------------------------------");

      // Use for-each loop to display marks of each subject
      int subjectIndex = 0;
      for (double mark : marks) {
         System.out.printf("  %-20s : %.1f%n", subjectNames[subjectIndex], mark);
         subjectIndex++;
      }

      System.out.println("----------------------------------------");
      System.out.printf("Total Marks   : %.1f / %.1f%n", totalMarks, numberOfSubjects * maxMarksPerSubject);
      System.out.printf("Average Marks : %.2f%n", averageMarks);
      System.out.printf("Percentage    : %.2f%%%n", percentage);
      System.out.println("Grade         : " + grade);
      System.out.println("Result        : " + resultStatus);
      System.out.println("========================================");

      // Close Scanner stream
      input.close();
   }
}
