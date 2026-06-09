// DivisibleByFive - Checks if a number is divisible by 5
import java.util.Scanner;

class DivisibleByFive {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer input from user and store in number
      System.out.print("Enter a number: ");
      int number = input.nextInt();

      // Check if number is divisible by 5 using modulus operator
      boolean isDivisibleByFive = (number % 5 == 0);

      // Print the result
      System.out.println("Is the number " + number + " divisible by 5? " + isDivisibleByFive);

      // Close Scanner stream
      input.close();
   }
}
