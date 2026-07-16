// FizzBuzzArray - FizzBuzz results saved in a String array and displayed by position
import java.util.Scanner;

class FizzBuzzArray {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input and store in number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Validate that number is a positive integer
      if (number <= 0) {
         System.err.println("Invalid input. Please enter a positive integer.");
         System.exit(0);
      }

      // Create a String array to save FizzBuzz results, size = number + 1 to include 0
      String[] fizzBuzzResults = new String[number + 1];

      // Loop from 0 to number and save results in the String array
      for (int i = 0; i <= number; i++) {
         // Check for multiples of both 3 and 5 and save "FizzBuzz"
         if (i % 3 == 0 && i % 5 == 0) {
            fizzBuzzResults[i] = "FizzBuzz";
         }
         // Check for multiples of 5 only and save "Buzz"
         else if (i % 5 == 0) {
            fizzBuzzResults[i] = "Buzz";
         }
         // Check for multiples of 3 only and save "Fizz"
         else if (i % 3 == 0) {
            fizzBuzzResults[i] = "Fizz";
         }
         // Otherwise save the number as a String
         else {
            fizzBuzzResults[i] = String.valueOf(i);
         }
      }

      // Loop again to display results for each index position
      System.out.println("\nFizzBuzz Results:");
      for (int i = 0; i < fizzBuzzResults.length; i++) {
         System.out.println("Position " + i + " = " + fizzBuzzResults[i]);
      }

      // Close Scanner stream
      input.close();
   }
}
