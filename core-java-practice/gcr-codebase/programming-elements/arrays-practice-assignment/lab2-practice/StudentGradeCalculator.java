// StudentGradeCalculator - Computes percentage and grade for students using 1D arrays
import java.util.Scanner;

class StudentGradeCalculator {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Take input for number of students
      System.out.print("Enter the number of students: ");
      int numberOfStudents = input.nextInt();

      // Validate number of students is positive
      if (numberOfStudents <= 0) {
         System.err.println("Invalid input. Number of students must be positive.");
         System.exit(0);
      }

      // Define number of subjects and maximum marks per subject as constants
      int numberOfSubjects = 3;
      double maxMarksPerSubject = 100.0;
      double totalMaxMarks = numberOfSubjects * maxMarksPerSubject;

      // Create arrays to store physics, chemistry, maths marks, percentages, and grades
      double[] physicsMarks = new double[numberOfStudents];
      double[] chemistryMarks = new double[numberOfStudents];
      double[] mathsMarks = new double[numberOfStudents];
      double[] percentages = new double[numberOfStudents];
      String[] grades = new String[numberOfStudents];

      // Take input for marks in each subject; re-ask if marks are negative
      for (int i = 0; i < numberOfStudents; i++) {
         System.out.println("\nStudent " + (i + 1) + " marks:");

         // Take physics marks and validate
         System.out.print("  Physics marks: ");
         physicsMarks[i] = input.nextDouble();
         if (physicsMarks[i] < 0) {
            System.out.println("  Marks cannot be negative. Please re-enter.");
            i--;
            continue;
         }

         // Take chemistry marks and validate
         System.out.print("  Chemistry marks: ");
         chemistryMarks[i] = input.nextDouble();
         if (chemistryMarks[i] < 0) {
            System.out.println("  Marks cannot be negative. Please re-enter.");
            i--;
            continue;
         }

         // Take maths marks and validate
         System.out.print("  Maths marks: ");
         mathsMarks[i] = input.nextDouble();
         if (mathsMarks[i] < 0) {
            System.out.println("  Marks cannot be negative. Please re-enter.");
            i--;
            continue;
         }
      }

      // Calculate percentage and grade for each student
      for (int i = 0; i < numberOfStudents; i++) {
         // Calculate percentage from total marks obtained over total max marks
         double totalMarks = physicsMarks[i] + chemistryMarks[i] + mathsMarks[i];
         percentages[i] = (totalMarks / totalMaxMarks) * 100;

         // Assign grade based on percentage
         if (percentages[i] >= 90) {
            grades[i] = "A+";
         } else if (percentages[i] >= 80) {
            grades[i] = "A";
         } else if (percentages[i] >= 70) {
            grades[i] = "B";
         } else if (percentages[i] >= 60) {
            grades[i] = "C";
         } else if (percentages[i] >= 50) {
            grades[i] = "D";
         } else {
            grades[i] = "F";
         }
      }

      // Display marks, percentage, and grade of each student
      System.out.println("\n--- Student Grade Report ---");
      System.out.printf("%-10s %-10s %-12s %-8s %-12s %-6s%n",
                        "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
      for (int i = 0; i < numberOfStudents; i++) {
         System.out.printf("%-10d %-10.1f %-12.1f %-8.1f %-12.2f %-6s%n",
                           (i + 1), physicsMarks[i], chemistryMarks[i],
                           mathsMarks[i], percentages[i], grades[i]);
      }

      // Close Scanner stream
      input.close();
   }
}
