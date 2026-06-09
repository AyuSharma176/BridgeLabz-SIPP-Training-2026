// MultiplesBelow100ForLoop - Finds all multiples of a number below 100 using for loop
import java.util.Scanner;

class MultiplesBelow100ForLoop {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input, validate it is a positive integer and less than 100
      System.out.print("Enter a positive integer less than 100: ");
      int number = input.nextInt();

      // Validate that number is a positive integer and less than 100
      if (number <= 0 || number >= 100) {
         System.out.println("Please enter a positive integer less than 100.");
      } else {
         System.out.println("Multiples of " + number + " below 100:");

         // Loop backward from 100 to 1 to find all multiples
         for (int i = 100; i >= 1; i--) {
            // Check if i is perfectly divisible by number
            if (i % number == 0) {
               System.out.println(i);
            }
         }
      }

      // Close Scanner stream
      input.close();
   }
}
