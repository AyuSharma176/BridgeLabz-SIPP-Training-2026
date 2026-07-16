// BMICalculator - Calculates BMI and weight status for multiple persons using 1D arrays
import java.util.Scanner;

class BMICalculator {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Take input for number of persons
      System.out.print("Enter the number of persons: ");
      int numberOfPersons = input.nextInt();

      // Validate number of persons is positive
      if (numberOfPersons <= 0) {
         System.err.println("Invalid input. Number of persons must be positive.");
         System.exit(0);
      }

      // Create arrays to store weight, height, BMI, and weight status
      double[] weights = new double[numberOfPersons];
      double[] heights = new double[numberOfPersons];
      double[] bmiValues = new double[numberOfPersons];
      String[] weightStatus = new String[numberOfPersons];

      // Take input for weight and height of each person
      for (int i = 0; i < numberOfPersons; i++) {
         System.out.println("\nPerson " + (i + 1) + ":");

         // Take weight input and validate
         System.out.print("  Enter weight (kg): ");
         weights[i] = input.nextDouble();
         if (weights[i] <= 0) {
            System.out.println("  Invalid weight. Please enter a positive value.");
            i--;
            continue;
         }

         // Take height input and validate
         System.out.print("  Enter height (m): ");
         heights[i] = input.nextDouble();
         if (heights[i] <= 0) {
            System.out.println("  Invalid height. Please enter a positive value.");
            i--;
            continue;
         }
      }

      // Calculate BMI and determine weight status for each person
      for (int i = 0; i < numberOfPersons; i++) {
         // BMI formula: weight / (height * height)
         bmiValues[i] = weights[i] / (heights[i] * heights[i]);

         // Determine weight status based on BMI ranges
         if (bmiValues[i] < 18.5) {
            weightStatus[i] = "Underweight";
         } else if (bmiValues[i] < 25.0) {
            weightStatus[i] = "Normal weight";
         } else if (bmiValues[i] < 30.0) {
            weightStatus[i] = "Overweight";
         } else {
            weightStatus[i] = "Obese";
         }
      }

      // Display height, weight, BMI, and weight status for each person
      System.out.println("\n--- BMI Report ---");
      System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                        "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
      for (int i = 0; i < numberOfPersons; i++) {
         System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %-15s%n",
                           (i + 1), heights[i], weights[i], bmiValues[i], weightStatus[i]);
      }

      // Close Scanner stream
      input.close();
   }
}
