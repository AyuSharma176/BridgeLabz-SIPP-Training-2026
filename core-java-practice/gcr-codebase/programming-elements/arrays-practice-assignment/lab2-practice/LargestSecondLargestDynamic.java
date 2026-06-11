// LargestSecondLargestDynamic - Finds largest/second largest digit with dynamic array resizing
import java.util.Scanner;

class LargestSecondLargestDynamic {
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

      // Define the initial maximum digits the array can hold
      int maxDigit = 10;

      // Define an array to store the digits, sized to maxDigit
      int[] digits = new int[maxDigit];

      // Create an index variable initialized to 0 for tracking array position
      int index = 0;

      // Loop until number becomes 0, extracting digits one by one
      while (number != 0) {
         // If index equals maxDigit, resize the array to store more elements
         if (index == maxDigit) {
            // Increase maxDigit by 10 to accommodate more digits
            maxDigit += 10;

            // Create a temp array of the new size
            int[] temp = new int[maxDigit];

            // Copy all existing digits from digits array into temp array
            for (int i = 0; i < digits.length; i++) {
               temp[i] = digits[i];
            }

            // Reassign digits array to the larger temp array
            digits = temp;
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

      // Loop through the digits array using index to find largest and second largest
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
      System.out.println("Total digits found: " + index);
      System.out.println("Largest digit: " + largestDigit);
      System.out.println("Second largest digit: " + secondLargestDigit);

      // Close Scanner stream
      input.close();
   }
}
