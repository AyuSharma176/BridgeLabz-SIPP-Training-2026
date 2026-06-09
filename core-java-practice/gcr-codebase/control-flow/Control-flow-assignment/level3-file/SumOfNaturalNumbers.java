// SumOfNaturalNumbers - Checks for natural number and computes sum of n natural numbers
import java.util.Scanner;

class SumOfNaturalNumbers {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer input from user and store in number
      System.out.print("Enter a number: ");
      int number = input.nextInt();

      // Check if number is a natural number (positive integer)
      if (number > 0) {
         // Calculate sum using formula n * (n + 1) / 2
         int sumOfNaturalNumbers = number * (number + 1) / 2;

         // Print the result
         System.out.println("The sum of " + number + " natural numbers is " + sumOfNaturalNumbers);
      } else {
         // Print that the number is not a natural number
         System.out.println("The number " + number + " is not a natural number");
      }

      // Close Scanner stream
      input.close();
   }
}
