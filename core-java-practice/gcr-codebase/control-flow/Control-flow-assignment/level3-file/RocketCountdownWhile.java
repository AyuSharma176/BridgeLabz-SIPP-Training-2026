// RocketCountdownWhile - Counts down from user input to 1 using a while loop
import java.util.Scanner;

class RocketCountdownWhile {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input for countdown start value
      System.out.print("Enter countdown start value: ");
      int counter = input.nextInt();

      System.out.println("Rocket Launch Countdown:");

      // Use while loop to count down from counter to 1
      while (counter >= 1) {
         // Print current counter value
         System.out.println(counter);

         // Decrement counter
         counter--;
      }

      // Print launch message after countdown
      System.out.println("Blast Off!");

      // Close Scanner stream
      input.close();
   }
}
