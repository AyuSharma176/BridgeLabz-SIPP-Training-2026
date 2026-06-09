// OddEvenPrinter - Prints odd and even numbers from 1 to user-entered number
import java.util.Scanner;

class OddEvenPrinter {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input and store in variable number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Check if number is a natural number (positive integer)
      if (number <= 0) {
         System.out.println("Please enter a positive integer.");
      } else {
         // Loop from 1 to number and check odd or even for each
         for (int i = 1; i <= number; i++) {
            // Check if i is even or odd using modulus operator
            if (i % 2 == 0) {
               System.out.println(i + " is an Even number");
            } else {
               System.out.println(i + " is an Odd number");
            }
         }
      }

      // Close Scanner stream
      input.close();
   }
}
