// BMICalculator2DArray - Calculates BMI and weight status using a 2D array
import java.util.Scanner;

class BMICalculator2DArray {
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

      // Define column index constants for the 2D array
      int weightColumn = 0;
      int heightColumn = 1;
      int bmiColumn = 2;

      // Create a 2D array to store weight (col 0), height (col 1), and BMI (col 2)
      double[][] personData = new double[numberOfPersons][3];

      // Create a String array to store the weight status of each person
      String[] weightStatus = new String[numberOfPersons];

      // Take input for weight and height of each person and validate
      for (int i = 0; i < numberOfPersons; i++) {
         System.out.println("\nPerson " + (i + 1) + ":");

         // Take weight input and ask again if invalid
         System.out.print("  Enter weight (kg): ");
         personData[i][weightColumn] = input.nextDouble();
         if (personData[i][weightColumn] <= 0) {
            System.out.println("  Invalid weight. Please enter a positive value.");
            i--;
            continue;
         }

         // Take height input and ask again if invalid
         System.out.print("  Enter height (m): ");
         personData[i][heightColumn] = input.nextDouble();
         if (personData[i][heightColumn] <= 0) {
            System.out.println("  Invalid height. Please enter a positive value.");
            i--;
            continue;
         }
      }

      // Calculate BMI and store in 2D array; determine weight status
      for (int i = 0; i < numberOfPersons; i++) {
         // BMI formula: weight / (height * height)
         personData[i][bmiColumn] = personData[i][weightColumn] /
               (personData[i][heightColumn] * personData[i][heightColumn]);

         // Determine weight status based on BMI value
         if (personData[i][bmiColumn] < 18.5) {
            weightStatus[i] = "Underweight";
         } else if (personData[i][bmiColumn] < 25.0) {
            weightStatus[i] = "Normal weight";
         } else if (personData[i][bmiColumn] < 30.0) {
            weightStatus[i] = "Overweight";
         } else {
            weightStatus[i] = "Obese";
         }
      }

      // Display height, weight, BMI, and status of each person
      System.out.println("\n--- BMI Report (2D Array) ---");
      System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                        "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
      for (int i = 0; i < numberOfPersons; i++) {
         System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %-15s%n",
                           (i + 1),
                           personData[i][heightColumn],
                           personData[i][weightColumn],
                           personData[i][bmiColumn],
                           weightStatus[i]);
      }

      // Close Scanner stream
      input.close();
   }
}
