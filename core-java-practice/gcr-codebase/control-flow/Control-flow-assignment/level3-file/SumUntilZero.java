// SumUntilZero - Finds the sum of numbers until the user enters 0
import java.util.Scanner;

class SumUntilZero {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Initialize total to 0.0 to accumulate sum
      double total = 0.0;

      // Get first user input to begin the loop
      System.out.print("Enter a number (0 to stop): ");
      double userEntry = input.nextDouble();

      // Use while loop to keep adding until user enters 0
      while (userEntry != 0) {
         // Add user entered value to total
         total += userEntry;

         // Ask user to enter next number
         System.out.print("Enter a number (0 to stop): ");
         userEntry = input.nextDouble();
      }

      // Display the total sum outside the loop
      System.out.println("The total sum is: " + total);

      // Close Scanner stream
      input.close();
   }
}
