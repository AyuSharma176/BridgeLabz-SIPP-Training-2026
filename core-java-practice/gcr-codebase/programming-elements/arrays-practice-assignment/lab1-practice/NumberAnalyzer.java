// NumberAnalyzer - Checks positive/negative/zero, odd/even, and compares first and last elements
import java.util.Scanner;

class NumberAnalyzer {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Define the array size as a constant variable
      int arraySize = 5;

      // Define an integer array of 5 elements
      int[] numbers = new int[arraySize];

      // Get user input for all 5 numbers and store in array
      System.out.println("Enter " + arraySize + " numbers:");
      for (int i = 0; i < numbers.length; i++) {
         System.out.print("Enter number " + (i + 1) + ": ");
         numbers[i] = input.nextInt();
      }

      // Loop through the array and check each number
      System.out.println("\nNumber Analysis:");
      for (int i = 0; i < numbers.length; i++) {
         int number = numbers[i];

         // Check if number is positive
         if (number > 0) {
            // Check if positive number is even or odd
            if (number % 2 == 0) {
               System.out.println(number + " is Positive and Even");
            } else {
               System.out.println(number + " is Positive and Odd");
            }
         }
         // Check if number is negative
         else if (number < 0) {
            System.out.println(number + " is Negative");
         }
         // Otherwise the number is zero
         else {
            System.out.println(number + " is Zero");
         }
      }

      // Compare the first and last elements of the array
      int firstElement = numbers[0];
      int lastElement = numbers[numbers.length - 1];

      System.out.println("\nComparing first (" + firstElement + ") and last (" + lastElement + ") elements:");

      // Check if first element equals, is greater than, or less than last element
      if (firstElement == lastElement) {
         System.out.println("The first and last elements are equal.");
      } else if (firstElement > lastElement) {
         System.out.println("The first element is greater than the last element.");
      } else {
         System.out.println("The first element is less than the last element.");
      }

      // Close Scanner stream
      input.close();
   }
}
