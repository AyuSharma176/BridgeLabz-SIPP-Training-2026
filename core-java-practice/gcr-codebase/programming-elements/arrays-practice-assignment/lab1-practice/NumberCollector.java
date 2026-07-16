// NumberCollector - Stores up to 10 user-entered numbers and displays them with their sum
import java.util.Scanner;

class NumberCollector {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Define maximum array size as a constant variable
      int maxArraySize = 10;

      // Create an array of 10 elements of type double to store user entries
      double[] numbers = new double[maxArraySize];

      // Initialize total and index variables
      double total = 0.0;
      int index = 0;

      System.out.println("Enter up to " + maxArraySize + " numbers (0 or negative to stop):");

      // Use infinite while loop to keep taking input until break conditions
      while (true) {
         System.out.print("Enter number " + (index + 1) + ": ");
         double userEntry = input.nextDouble();

         // Break if user enters 0 or a negative number
         if (userEntry <= 0) {
            break;
         }

         // Break if array is full (index has reached max size)
         if (index == maxArraySize) {
            System.out.println("Maximum limit of " + maxArraySize + " numbers reached.");
            break;
         }

         // Assign the entered number to the current array element and increment index
         numbers[index] = userEntry;
         index++;
      }

      // Loop through collected elements and add each to total
      for (int i = 0; i < index; i++) {
         total += numbers[i];
      }

      // Display all numbers entered by the user
      System.out.println("\nNumbers entered:");
      for (int i = 0; i < index; i++) {
         System.out.println("  " + numbers[i]);
      }

      // Display the total sum
      System.out.println("Total sum: " + total);

      // Close Scanner stream
      input.close();
   }
}
