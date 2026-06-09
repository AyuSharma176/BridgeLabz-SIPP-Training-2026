// LargestNumberChecker - Checks which of three numbers is the largest
import java.util.Scanner;

class LargestNumberChecker {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get three integer inputs from user
      System.out.print("Enter number1: ");
      int number1 = input.nextInt();

      System.out.print("Enter number2: ");
      int number2 = input.nextInt();

      System.out.print("Enter number3: ");
      int number3 = input.nextInt();

      // Check if number1 is the largest
      boolean isFirstLargest = (number1 > number2 && number1 > number3);

      // Check if number2 is the largest
      boolean isSecondLargest = (number2 > number1 && number2 > number3);

      // Check if number3 is the largest
      boolean isThirdLargest = (number3 > number1 && number3 > number2);

      // Print results for all three numbers
      System.out.println("Is the first number the largest? " + isFirstLargest);
      System.out.println("Is the second number the largest? " + isSecondLargest);
      System.out.println("Is the third number the largest? " + isThirdLargest);

      // Close Scanner stream
      input.close();
   }
}
