// MultiplicationTableArray - Stores multiplication table in an array and displays it
import java.util.Scanner;

class MultiplicationTableArray {
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

      // Define the table range as a constant variable
      int tableRange = 10;

      // Define an integer array to store results of multiplication from 1 to 10
      int[] multiplicationTable = new int[tableRange];

      // Run a loop from 1 to 10 and store results in the multiplication table array
      for (int i = 0; i < multiplicationTable.length; i++) {
         // Store result of number * (i+1) in the array
         multiplicationTable[i] = number * (i + 1);
      }

      // Display the result from the array in the required format
      System.out.println("\nMultiplication Table of " + number + ":");
      for (int i = 0; i < multiplicationTable.length; i++) {
         System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
      }

      // Close Scanner stream
      input.close();
   }
}
