// LargestSecondLargestDigit - Finds largest and second largest digit of a number
import java.util.Scanner;

class LargestSecondLargestDigit {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Take user input for the number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Validate that number is a positive integer
      if (number <= 0) {
         System.err.println("Invalid input. Please enter a positive integer.");
         System.exit(0);
      }

      // Define the maximum digits the array can hold initially
      int maxDigit = 10;

      // Define an array to store the digits, sized to maxDigit
      int[] digits = new int[maxDigit];

      // Create an index variable initialized to 0 for tracking array position
      int index = 0;

      // Loop until number becomes 0, extracting digits one by one
      while (number != 0) {
         // Break out of loop if index reaches maxDigit limit
         if (index == maxDigit) {
            break;
         }

         // Remove last digit and store it in the array
         digits[index] = number % 10;
         number /= 10;

         // Increment index
         index++;
      }

      // Define variables for largest and second largest digit, initialized to zero
      int largestDigit = 0;
      int secondLargestDigit = 0;

      // Loop through the digits array to find largest and second largest digit
      for (int i = 0; i < index; i++) {
         // Check if current digit is greater than largest
         if (digits[i] > largestDigit) {
            // Move old largest to second largest before updating largest
            secondLargestDigit = largestDigit;
            largestDigit = digits[i];
         }
         // Check if current digit is between largest and second largest
         else if (digits[i] > secondLargestDigit && digits[i] != largestDigit) {
            secondLargestDigit = digits[i];
         }
      }

      // Display the largest and second largest digit
      System.out.println("Largest digit: " + largestDigit);
      System.out.println("Second largest digit: " + secondLargestDigit);

      // Close Scanner stream
      input.close();
   }
}
