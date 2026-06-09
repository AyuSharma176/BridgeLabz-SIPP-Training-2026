// SumNaturalWhile - Sum of n natural numbers using while loop, verified with formula
import java.util.Scanner;

class SumNaturalWhile {
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

         // Compute sum using while loop
         int sumByLoop = 0;
         int counter = 1;

         // Add each number from 1 to n using while loop
         while (counter <= number) {
            sumByLoop += counter;
            counter++;
         }

         // Compare both results and display
         System.out.println("Sum using formula: " + sumByFormula);
         System.out.println("Sum using while loop: " + sumByLoop);
         System.out.println("Both results match: " + (sumByFormula == sumByLoop));
      }

      // Close Scanner stream
      input.close();
   }
}
