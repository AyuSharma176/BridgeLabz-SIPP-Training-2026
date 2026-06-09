// FactorsForLoop - Finds all factors of a number using a for loop
import java.util.Scanner;

class FactorsForLoop {
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

         // Loop from 1 to number - 1 to find all factors
         for (int i = 1; i < number; i++) {
            // Check if number is perfectly divisible by i
            if (number % i == 0) {
               System.out.println(i);
            }
         }
      }

      // Close Scanner stream
      input.close();
   }
}
