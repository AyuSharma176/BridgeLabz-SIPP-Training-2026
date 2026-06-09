// GreatestFactorForLoop - Finds the greatest factor of a number using a for loop
import java.util.Scanner;

class GreatestFactorForLoop {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input and store in number
      System.out.print("Enter a positive integer: ");
      int number = input.nextInt();

      // Define greatestFactor variable and initialize to 1
      int greatestFactor = 1;

      // Loop from number - 1 down to 1 to find greatest factor
      for (int i = number - 1; i >= 1; i--) {
         // Check if number is perfectly divisible by i
         if (number % i == 0) {
            // Assign i to greatestFactor and break out of loop
            greatestFactor = i;
            break;
         }
      }

      // Display the greatest factor outside the loop
      System.out.println("The greatest factor of " + number +
                         " (besides itself) is: " + greatestFactor);

      // Close Scanner stream
      input.close();
   }
}
