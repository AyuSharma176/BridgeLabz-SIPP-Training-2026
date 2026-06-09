// MultiplicationTable - Prints multiplication table of a number from 6 to 9
import java.util.Scanner;

class MultiplicationTable {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get integer input from user and store in number
      System.out.print("Enter an integer: ");
      int number = input.nextInt();

      System.out.println("Multiplication table of " + number + " from 6 to 9:");

      // Loop from 6 to 9 and print the multiplication table
      for (int i = 6; i <= 9; i++) {
         // Calculate product and print in required format
         int product = number * i;
         System.out.println(number + " * " + i + " = " + product);
      }

      // Close Scanner stream
      input.close();
   }
}
