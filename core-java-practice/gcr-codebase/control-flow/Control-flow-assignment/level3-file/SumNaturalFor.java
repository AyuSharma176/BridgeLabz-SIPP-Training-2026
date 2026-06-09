// SumNaturalFor - Sum of n natural numbers using for loop, verified with formula
import java.util.Scanner;

class SumNaturalFor {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input and store in number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Check if number is a natural number
      if (number <= 0) {
         System.out.println("The number " + number + " is not a natural number.");
      } else {
         // Compute sum using formula n * (n + 1) / 2
         int sumByFormula = number * (number + 1) / 2;

         // Compute sum using for loop
         int sumByLoop = 0;

         // Add each number from 1 to n using for loop
         for (int i = 1; i <= number; i++) {
            sumByLoop += i;
         }

         // Compare both results and display
         System.out.println("Sum using formula: " + sumByFormula);
         System.out.println("Sum using for loop: " + sumByLoop);
         System.out.println("Both results match: " + (sumByFormula == sumByLoop));
      }

      // Close Scanner stream
      input.close();
   }
}
