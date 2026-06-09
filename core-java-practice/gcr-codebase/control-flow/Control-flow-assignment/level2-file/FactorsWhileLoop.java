// FactorsWhileLoop - Finds all factors of a number using a while loop
import java.util.Scanner;

class FactorsWhileLoop {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input and check it is a positive integer
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Validate that number is a positive integer
      if (number <= 0) {
         System.out.println("Please enter a positive integer.");
      } else {
         System.out.println("Factors of " + number + " are:");

         // Initialize counter variable for while loop
         int counter = 1;

         // Run while loop till counter is less than number
         while (counter < number) {
            // Check if number is perfectly divisible by counter
            if (number % counter == 0) {
               System.out.println(counter);
            }

            // Increment counter
            counter++;
         }
      }

      // Close Scanner stream
      input.close();
   }
}
