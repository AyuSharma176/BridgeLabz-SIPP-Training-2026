// MultiplicationTable6To9 - Stores multiplication table results (6 to 9) in an array and displays
import java.util.Scanner;

class MultiplicationTable6To9 {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer input from user and store in number
      System.out.print("Enter a number: ");
      int number = input.nextInt();

      // Validate that number is a positive integer
      if (number <= 0) {
         System.err.println("Invalid input. Please enter a positive integer.");
         System.exit(0);
      }

      // Define start and end range for multiplication table
      int startRange = 6;
      int endRange = 9;

      // Define array size based on range
      int arraySize = endRange - startRange + 1;

      // Define an integer array to store the multiplication results
      int[] multiplicationResult = new int[arraySize];

      // Loop from 6 to 9 and save the result in the array
      for (int i = startRange; i <= endRange; i++) {
         // Store result in array using adjusted index
         multiplicationResult[i - startRange] = number * i;
      }

      // Display the result from the array in the required format
      System.out.println("\nMultiplication Table of " + number + " from " + startRange + " to " + endRange + ":");
      for (int i = 0; i < multiplicationResult.length; i++) {
         System.out.println(number + " * " + (i + startRange) + " = " + multiplicationResult[i]);
      }

      // Close Scanner stream
      input.close();
   }
}
