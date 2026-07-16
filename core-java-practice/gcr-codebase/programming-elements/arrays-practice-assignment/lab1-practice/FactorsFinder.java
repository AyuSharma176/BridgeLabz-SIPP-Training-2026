// FactorsFinder - Finds factors of a number, stores them in a dynamic array, and displays them
import java.util.Scanner;

class FactorsFinder {
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

      // Create integer variable maxFactor initialized to 10 for initial array size
      int maxFactor = 10;

      // Create the factors array of initial size maxFactor
      int[] factors = new int[maxFactor];

      // Create index variable to track current position in factors array
      int index = 0;

      // Loop from 1 to number to find all factors
      for (int i = 1; i <= number; i++) {
         // Check if number is perfectly divisible by i
         if (number % i == 0) {
            // If index equals maxFactor, resize the array to store more elements
            if (index == maxFactor) {
               // Reset maxFactor to twice its current size
               maxFactor = maxFactor * 2;

               // Create a temp array to hold existing elements
               int[] temp = new int[maxFactor];

               // Copy all elements from factors array to temp array
               for (int k = 0; k < factors.length; k++) {
                  temp[k] = factors[k];
               }

               // Reassign factors array to the larger temp array
               factors = temp;
            }

            // Store the factor in the array and increment the index
            factors[index] = i;
            index++;
         }
      }

      // Display all factors of the number using the index count
      System.out.println("\nFactors of " + number + ":");
      for (int i = 0; i < index; i++) {
         System.out.print(factors[i] + " ");
      }
      System.out.println();

      // Close Scanner stream
      input.close();
   }
}
