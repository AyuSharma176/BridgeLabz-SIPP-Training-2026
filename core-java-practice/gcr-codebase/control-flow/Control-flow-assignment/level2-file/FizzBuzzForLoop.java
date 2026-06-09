// FizzBuzzForLoop - FizzBuzz program using a for loop
import java.util.Scanner;

class FizzBuzzForLoop {
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
         // Loop from 1 to number using for loop
         for (int i = 1; i <= number; i++) {
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
         }
      }

      // Close Scanner stream
      input.close();
   }
}
