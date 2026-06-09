// FactorialFor - Computes the factorial of a user-entered integer using for loop
import java.util.Scanner;

class FactorialFor {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer input from user and store in number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Check if number is a positive integer (natural number)
      if (number <= 0) {
         System.out.println("Please enter a positive integer.");
      } else {
         // Initialize factorial variable to 1
         long factorial = 1;

         // Use for loop to compute factorial by multiplying 1 through number
         for (int i = 1; i <= number; i++) {
            // Multiply factorial by current loop variable i
            factorial *= i;
         }

         // Print the factorial result
         System.out.println("The factorial of " + number + " is: " + factorial);
      }

      // Close Scanner stream
      input.close();
   }
}
