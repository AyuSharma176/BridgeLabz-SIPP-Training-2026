// StudentGradeCalculator2D - Computes percentage and grade using a 2D array for marks
import java.util.Scanner;

class StudentGradeCalculator2D {
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

      // Define column index constants for physics, chemistry, and maths
      int physicsColumn = 0;
      int chemistryColumn = 1;
      int mathsColumn = 2;

      // Define number of subjects and maximum marks per subject as constants
      int numberOfSubjects = 3;
      double maxMarksPerSubject = 100.0;
      double totalMaxMarks = numberOfSubjects * maxMarksPerSubject;

      // Create a 2D array to store marks: rows = students, columns = subjects
      double[][] marks = new double[numberOfStudents][numberOfSubjects];

      // Create arrays to store percentages and grades of the students
      double[] percentages = new double[numberOfStudents];
      String[] grades = new String[numberOfStudents];

      // Take input for marks of each student in all subjects; re-ask if negative
      for (int i = 0; i < numberOfStudents; i++) {
         System.out.println("\nStudent " + (i + 1) + " marks:");

         // Take physics marks and validate
         System.out.print("  Physics marks: ");
         marks[i][physicsColumn] = input.nextDouble();
         if (marks[i][physicsColumn] < 0) {
            System.out.println("  Marks cannot be negative. Please re-enter.");
            i--;
            continue;
         }

         // Take chemistry marks and validate
         System.out.print("  Chemistry marks: ");
         marks[i][chemistryColumn] = input.nextDouble();
         if (marks[i][chemistryColumn] < 0) {
            System.out.println("  Marks cannot be negative. Please re-enter.");
            i--;
            continue;
         }

         // Take maths marks and validate
         System.out.print("  Maths marks: ");
         marks[i][mathsColumn] = input.nextDouble();
         if (marks[i][mathsColumn] < 0) {
            System.out.println("  Marks cannot be negative. Please re-enter.");
            i--;
            continue;
         }
      }

      // Calculate percentage and grade for each student using the 2D marks array
      for (int i = 0; i < numberOfStudents; i++) {
         // Sum all subject marks for the student from 2D array
         double totalMarks = 0;
         for (int j = 0; j < numberOfSubjects; j++) {
            totalMarks += marks[i][j];
         }

         // Calculate percentage from total marks obtained over total max marks
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
      System.out.println("\n--- Student Grade Report (2D Array) ---");
      System.out.printf("%-10s %-10s %-12s %-8s %-12s %-6s%n",
                        "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
      for (int i = 0; i < numberOfStudents; i++) {
         System.out.printf("%-10d %-10.1f %-12.1f %-8.1f %-12.2f %-6s%n",
                           (i + 1),
                           marks[i][physicsColumn],
                           marks[i][chemistryColumn],
                           marks[i][mathsColumn],
                           percentages[i],
                           grades[i]);
      }

      // Close Scanner stream
      input.close();
   }
}
