// StudentVotingEligibility - Checks voting eligibility for 10 students using an array
import java.util.Scanner;

class StudentVotingEligibility {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Define the number of students as a constant variable
      int numberOfStudents = 10;

      // Define an array of 10 integer elements to store student ages
      int[] studentAges = new int[numberOfStudents];

      // Take user input for each student's age and store in array
      System.out.println("Enter the ages of " + numberOfStudents + " students:");
      for (int i = 0; i < studentAges.length; i++) {
         System.out.print("Enter age of student " + (i + 1) + ": ");
         studentAges[i] = input.nextInt();
      }

      // Define minimum voting age as a constant variable
      int minimumVotingAge = 18;

      // Loop through the array using length property and check voting eligibility
      System.out.println("\nVoting Eligibility Results:");
      for (int i = 0; i < studentAges.length; i++) {
         int age = studentAges[i];

         // Check if age is negative and print invalid age
         if (age < 0) {
            System.out.println("Student " + (i + 1) + ": Invalid age (" + age + ")");
         }
         // Check if age is 18 or above and print can vote
         else if (age >= minimumVotingAge) {
            System.out.println("The student with the age " + age + " can vote.");
         }
         // Otherwise print cannot vote
         else {
            System.out.println("The student with the age " + age + " cannot vote.");
         }
      }

      // Close Scanner stream
      input.close();
   }
}
