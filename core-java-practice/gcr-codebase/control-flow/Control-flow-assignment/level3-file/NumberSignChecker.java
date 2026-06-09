// NumberSignChecker - Checks if a number is positive, negative, or zero
import java.util.Scanner;

class NumberSignChecker {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer input from user and store in number
      System.out.print("Enter a number: ");
      int number = input.nextInt();

      // Check if number is positive, negative, or zero and print result
      if (number > 0) {
         System.out.println(number + " is a Positive number.");
      } else if (number < 0) {
         System.out.println(number + " is a Negative number.");
      } else {
         System.out.println("The number is Zero.");
      }

      // Close Scanner stream
      input.close();
   }
}
