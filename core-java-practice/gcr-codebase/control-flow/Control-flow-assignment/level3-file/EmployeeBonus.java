// EmployeeBonus - Calculates bonus for employees based on years of service
import java.util.Scanner;

class EmployeeBonus {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get salary and years of service from user
      System.out.print("Enter employee salary: ");
      double salary = input.nextDouble();

      System.out.print("Enter years of service: ");
      int yearsOfService = input.nextInt();

      // Declare bonus variable and initialize to zero
      double bonusAmount = 0;

      // Check if years of service is more than 5, then calculate 5% bonus
      if (yearsOfService > 5) {
         bonusAmount = salary * 0.05;
         System.out.println("Employee qualifies for a bonus!");
         System.out.println("Bonus Amount (5% of salary): " + bonusAmount);
      } else {
         System.out.println("Employee does not qualify for a bonus.");
         System.out.println("Bonus Amount: " + bonusAmount);
      }

      // Close Scanner stream
      input.close();
   }
}
