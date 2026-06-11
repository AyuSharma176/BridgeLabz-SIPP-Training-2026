// DigitFrequencyFinder - Finds the frequency of each digit in a number using arrays
import java.util.Scanner;

class DigitFrequencyFinder {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Take input for a number
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

      // Extract each digit and store in digits array
      for (int i = 0; i < digits.length; i++) {
         digits[i] = number % 10;
         number /= 10;
      }

      // Define possible digit values (0 through 9) as a constant
      int numberOfPossibleDigits = 10;

      // Define a frequency array of size 10 to count occurrences of each digit
      int[] frequency = new int[numberOfPossibleDigits];

      // Loop through the digits array and increment frequency for each digit found
      for (int i = 0; i < digits.length; i++) {
         frequency[digits[i]]++;
      }

      // Display the frequency of each digit that appears in the number
      System.out.println("\nDigit frequencies in " + originalNumber + ":");
      for (int i = 0; i < frequency.length; i++) {
         // Only display digits that appear at least once
         if (frequency[i] > 0) {
            System.out.println("Digit " + i + " appears " + frequency[i] + " time(s)");
         }
      }

      // Close Scanner stream
      input.close();
   }
}
