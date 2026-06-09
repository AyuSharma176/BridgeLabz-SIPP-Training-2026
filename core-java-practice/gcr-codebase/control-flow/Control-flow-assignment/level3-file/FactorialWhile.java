// FactorialWhile - Computes the factorial of a user-entered integer using while loop
import java.util.Scanner;

class FactorialWhile {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer input from user and store in number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Check if number is a positive integer
      if (number <= 0) {
         System.out.println("Please enter a positive integer.");
      } else {
         // Initialize factorial variable to 1
         long factorial = 1;

         // Initialize counter for while loop
         int counter = 1;

         // Use while loop to compute factorial by multiplying 1 through number
         while (counter <= number) {
            // Multiply factorial by current counter value
            factorial *= counter;

            // Increment counter
            counter++;
         }

         // Print the factorial result
         System.out.println("The factorial of " + number + " is: " + factorial);
      }

      // Close Scanner stream
      input.close();
   }
}
