// VotingEligibilityChecker - Checks if a person is eligible to vote based on age
import java.util.Scanner;

class VotingEligibilityChecker {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer input for age from user
      System.out.print("Enter your age: ");
      int age = input.nextInt();

      // Check if age is 18 or older to determine voting eligibility
      if (age >= 18) {
         System.out.println("The person's age is " + age + " and can vote.");
      } else {
         System.out.println("The person's age is " + age + " and cannot vote.");
      }

      // Close Scanner stream
      input.close();
   }
}
