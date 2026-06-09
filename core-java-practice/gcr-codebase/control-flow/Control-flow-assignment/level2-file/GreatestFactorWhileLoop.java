// GreatestFactorWhileLoop - Finds the greatest factor of a number using a while loop
import java.util.Scanner;

class GreatestFactorWhileLoop {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input and store in number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Define greatestFactor variable and initialize to 1
      int greatestFactor = 1;

      // Initialize counter to number - 1 for while loop
      int counter = number - 1;

      // Run while loop while counter is >= 1
      while (counter >= 1) {
         // Check if number is perfectly divisible by counter
         if (number % counter == 0) {
            // Assign counter to greatestFactor and break out of loop
            greatestFactor = counter;
            break;
         }

         // Decrement counter
         counter--;
      }

      // Display the greatest factor outside the loop
      System.out.println("The greatest factor of " + number +
                         " (besides itself) is: " + greatestFactor);

      // Close Scanner stream
      input.close();
   }
}
