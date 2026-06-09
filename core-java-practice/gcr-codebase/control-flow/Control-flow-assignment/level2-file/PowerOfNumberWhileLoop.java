// PowerOfNumberWhileLoop - Calculates the power of a number using a while loop
import java.util.Scanner;

class PowerOfNumberWhileLoop {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer inputs for number and power
      System.out.print("Enter the base number (positive integer): ");
      int number = input.nextInt();
      System.out.print("Enter the power/exponent (positive integer): ");
      int power = input.nextInt();

      // Validate that both number and power are positive integers
      if (number <= 0 || power <= 0) {
         System.out.println("Please enter positive integers for both values.");
      } else {
         // Initialize result variable to 1
         int result = 1;

         // Initialize counter variable to zero for while loop
         int counter = 0;

         // Run while loop until counter equals power
         while (counter != power) {
            // Multiply result by number in each iteration
            result = result * number;

            // Increment counter
            counter++;
         }

         // Print the final result
         System.out.println(number + " raised to the power " + power +
                            " = " + result);
      }

      // Close Scanner stream
      input.close();
   }
}
