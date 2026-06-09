// SmallestNumberChecker - Checks if the first of three numbers is the smallest
import java.util.Scanner;

class SmallestNumberChecker {
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

      // Check if number1 is smaller than both number2 and number3
      boolean isFirstSmallest = (number1 < number2 && number1 < number3);

      // Print the result
      System.out.println("Is the first number the smallest? " + isFirstSmallest);

      // Close Scanner stream
      input.close();
   }
}
