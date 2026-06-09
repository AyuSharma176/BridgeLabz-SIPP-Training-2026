// FizzBuzzWhileLoop - FizzBuzz program using a while loop
import java.util.Scanner;

class FizzBuzzWhileLoop {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input and store in number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Check if number is a positive integer
      if (number <= 0) {
         System.out.println("Please enter a positive integer.");
      } else {
         // Initialize counter for while loop
         int i = 1;

         // Run while loop from 1 to number
         while (i <= number) {
            // Check for multiples of both 3 and 5
            if (i % 3 == 0 && i % 5 == 0) {
               System.out.println("FizzBuzz");
            }
            // Check for multiples of 5 only
            else if (i % 5 == 0) {
               System.out.println("Buzz");
            }
            // Check for multiples of 3 only
            else if (i % 3 == 0) {
               System.out.println("Fizz");
            }
            // Print the number if no condition matches
            else {
               System.out.println(i);
            }

            // Increment counter
            i++;
         }
      }

      // Close Scanner stream
      input.close();
   }
}
