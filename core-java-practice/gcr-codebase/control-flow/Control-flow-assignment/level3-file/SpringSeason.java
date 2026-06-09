// SpringSeason - Checks if a given month and day falls within Spring Season
import java.util.Scanner;

class SpringSeason {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get month and day as integer inputs from user
      System.out.print("Enter month (1-12): ");
      int month = input.nextInt();

      System.out.print("Enter day (1-31): ");
      int day = input.nextInt();

      // Spring Season is from March 20 to June 20
      // Check if date falls within spring: (month == 3 && day >= 20) OR
      // (month == 4 or 5) OR (month == 6 && day <= 20)
      boolean isSpring = (month == 3 && day >= 20) ||
                         (month == 4) ||
                         (month == 5) ||
                         (month == 6 && day <= 20);

      // Print result based on whether date is in Spring
      if (isSpring) {
         System.out.println("Its a Spring Season");
      } else {
         System.out.println("Not a Spring Season");
      }

      // Close Scanner stream
      input.close();
   }
}
