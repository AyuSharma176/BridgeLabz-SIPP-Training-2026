// RocketCountdownFor - Counts down from user input to 1 using a for loop
import java.util.Scanner;

class RocketCountdownFor {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get user input for countdown start value
      System.out.print("Enter countdown start value: ");
      int startValue = input.nextInt();

      System.out.println("Rocket Launch Countdown:");

      // Use for loop to count down from startValue to 1
      for (int counter = startValue; counter >= 1; counter--) {
         // Print current counter value
         System.out.println(counter);
      }

      // Print launch message after countdown
      System.out.println("Blast Off!");

      // Close Scanner stream
      input.close();
   }
}
