// SumUntilZeroOrNegative - Finds the sum of numbers until user enters 0 or negative using break
import java.util.Scanner;

class SumUntilZeroOrNegative {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Initialize total to 0.0 to accumulate sum
      double total = 0.0;

      // Use infinite while loop with break statement
      while (true) {
         // Ask user to enter a number
         System.out.print("Enter a number (0 or negative to stop): ");
         double userEntry = input.nextDouble();

         // Break out of loop if user enters 0 or a negative number
         if (userEntry <= 0) {
            break;
         }

         // Add user entered value to total
         total += userEntry;
      }

      // Display the total sum outside the loop
      System.out.println("The total sum is: " + total);

      // Close Scanner stream
      input.close();
   }
}
