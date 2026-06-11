// ReverseNumber - Reverses a number by storing digits in array and displaying in reverse
import java.util.Scanner;

class ReverseNumber {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Take user input for a number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Validate that number is a positive integer
      if (number <= 0) {
         System.err.println("Invalid input. Please enter a positive integer.");
         System.exit(0);
      }

      // Save original number for display purposes
      int originalNumber = number;

      // Find the count of digits in the number
      int digitCount = 0;
      int temp = number;
      while (temp > 0) {
         digitCount++;
         temp /= 10;
      }

      // Define array to store digits of the number
      int[] digits = new int[digitCount];

      // Extract digits from the number and store in digits array
      for (int i = 0; i < digits.length; i++) {
         digits[i] = number % 10;
         number /= 10;
      }

      // Create an array to store digits in reverse order
      int[] reversedDigits = new int[digitCount];

      // Copy elements from digits array in reverse order into reversedDigits array
      for (int i = 0; i < reversedDigits.length; i++) {
         reversedDigits[i] = digits[digitCount - 1 - i];
      }

      // Display the reversed number by printing all elements of reversedDigits array
      System.out.print("Reversed number of " + originalNumber + " is: ");
      for (int i = 0; i < reversedDigits.length; i++) {
         System.out.print(reversedDigits[i]);
      }
      System.out.println();

      // Close Scanner stream
      input.close();
   }
}
