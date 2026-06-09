// MultiplesBelow100WhileLoop - Finds all multiples of a number below 100 using while loop
import java.util.Scanner;

class MultiplesBelow100WhileLoop {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input, validate it is a positive integer and less than 100
      System.out.print("Enter a positive integer less than 100: ");
      int number = input.nextInt();

      // Validate that number is a positive integer and less than 100
      if (number <= 0 || number >= 100) {
         System.out.println("Please enter a positive integer less than 100.");
      } else {
         System.out.println("Multiples of " + number + " below 100:");

         // Initialize counter to 100 for while loop going backward
         int counter = 100;

         // Run while loop while counter is greater than 1
         while (counter > 1) {
            // Check if counter is perfectly divisible by number
            if (counter % number == 0) {
               System.out.println(counter);
            }

            // Decrement counter
            counter--;
         }
      }

      // Close Scanner stream
      input.close();
   }
}
