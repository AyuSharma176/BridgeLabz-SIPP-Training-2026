// EmployeeBonusCalculator - Finds bonus for 10 employees based on years of service
import java.util.Scanner;

class EmployeeBonusCalculator {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Define number of employees as a constant variable
      int numberOfEmployees = 10;

      // Define bonus percentage thresholds and rates as constant variables
      double seniorBonusRate = 0.05;
      double juniorBonusRate = 0.02;
      int seniorServiceThreshold = 5;

      // Define arrays to store salary and years of service for each employee
      double[] salaries = new double[numberOfEmployees];
      double[] yearsOfService = new double[numberOfEmployees];

      // Define arrays to store new salary and bonus amount for each employee
      double[] newSalaries = new double[numberOfEmployees];
      double[] bonusAmounts = new double[numberOfEmployees];

      // Define variables to store total bonus, total old salary, and total new salary
      double totalBonus = 0.0;
      double totalOldSalary = 0.0;
      double totalNewSalary = 0.0;

      // Loop to take input for each employee's salary and years of service
      for (int i = 0; i < numberOfEmployees; i++) {
         System.out.println("\nEmployee " + (i + 1) + " details:");

         // Take salary input and validate; if invalid, ask user to enter again
         System.out.print("  Enter salary: ");
         salaries[i] = input.nextDouble();
         if (salaries[i] <= 0) {
            System.out.println("  Invalid salary. Please enter a positive value.");
            i--; // Decrement index to re-enter this employee's data
            continue;
         }

         // Take years of service input and validate; if invalid, ask user to enter again
         System.out.print("  Enter years of service: ");
         yearsOfService[i] = input.nextDouble();
         if (yearsOfService[i] < 0) {
            System.out.println("  Invalid years of service. Please enter a non-negative value.");
            i--; // Decrement index to re-enter this employee's data
            continue;
         }
      }

      // Loop to calculate bonus and new salary for each employee
      for (int i = 0; i < numberOfEmployees; i++) {
         // Apply 5% bonus for more than 5 years of service, else 2%
         if (yearsOfService[i] > seniorServiceThreshold) {
            bonusAmounts[i] = salaries[i] * seniorBonusRate;
         } else {
            bonusAmounts[i] = salaries[i] * juniorBonusRate;
         }

         // Calculate new salary by adding bonus to old salary
         newSalaries[i] = salaries[i] + bonusAmounts[i];

         // Accumulate total bonus, total old salary, and total new salary
         totalBonus += bonusAmounts[i];
         totalOldSalary += salaries[i];
         totalNewSalary += newSalaries[i];
      }

      // Print individual employee details
      System.out.println("\n--- Employee Bonus Summary ---");
      for (int i = 0; i < numberOfEmployees; i++) {
         System.out.println("Employee " + (i + 1) +
               " | Old Salary: " + salaries[i] +
               " | Bonus: " + bonusAmounts[i] +
               " | New Salary: " + newSalaries[i]);
      }

      // Print total bonus payout, total old salary, and total new salary
      System.out.println("\nTotal Old Salary:  " + totalOldSalary);
      System.out.println("Total Bonus Payout: " + totalBonus);
      System.out.println("Total New Salary:  " + totalNewSalary);

      // Close Scanner stream
      input.close();
   }
}
