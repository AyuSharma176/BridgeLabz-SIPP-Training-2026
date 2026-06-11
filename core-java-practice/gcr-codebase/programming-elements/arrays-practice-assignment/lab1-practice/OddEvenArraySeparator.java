// OddEvenArraySeparator - Saves odd and even numbers from 1 to N into separate arrays
import java.util.Scanner;

class OddEvenArraySeparator {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer input from user and store in number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Validate that number is a natural number; if not, print error and exit
      if (number <= 0) {
         System.err.println("Invalid input. Please enter a positive integer.");
         System.exit(0);
      }

      // Create integer arrays for even and odd numbers with size = number / 2 + 1
      int[] evenNumbers = new int[number / 2 + 1];
      int[] oddNumbers = new int[number / 2 + 1];

      // Create index variables for odd and even arrays, initialized to zero
      int evenIndex = 0;
      int oddIndex = 0;

      // Loop from 1 to number and store each number in the corresponding array
      for (int i = 1; i <= number; i++) {
         // Check if number is even and store in evenNumbers array
         if (i % 2 == 0) {
            evenNumbers[evenIndex] = i;
            evenIndex++;
         }
         // Otherwise store in oddNumbers array
         else {
            oddNumbers[oddIndex] = i;
            oddIndex++;
         }
      }

      // Print all even numbers using the evenIndex
      System.out.println("\nEven numbers from 1 to " + number + ":");
      for (int i = 0; i < evenIndex; i++) {
         System.out.print(evenNumbers[i] + " ");
      }

      // Print all odd numbers using the oddIndex
      System.out.println("\n\nOdd numbers from 1 to " + number + ":");
      for (int i = 0; i < oddIndex; i++) {
         System.out.print(oddNumbers[i] + " ");
      }
      System.out.println();

      // Close Scanner stream
      input.close();
   }
}
