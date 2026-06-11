// FootballTeamMeanHeight - Calculates the mean height of 11 football players
import java.util.Scanner;

class FootballTeamMeanHeight {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Define team size as a constant variable
      int teamSize = 11;

      // Create a double array named heights of size 11
      double[] heights = new double[teamSize];

      // Get input values for heights of all players from the user
      System.out.println("Enter the heights (in cm) of " + teamSize + " players:");
      for (int i = 0; i < heights.length; i++) {
         System.out.print("Player " + (i + 1) + " height: ");
         heights[i] = input.nextDouble();

         // Validate that height is a positive value
         if (heights[i] <= 0) {
            System.err.println("Invalid height. Height must be a positive number.");
            System.exit(0);
         }
      }

      // Find the sum of all elements in the heights array
      double sumOfHeights = 0.0;
      for (int i = 0; i < heights.length; i++) {
         sumOfHeights += heights[i];
      }

      // Divide the sum by teamSize to calculate mean height
      double meanHeight = sumOfHeights / teamSize;

      // Print the mean height of the football team
      System.out.println("\nMean height of the football team: " + meanHeight + " cm");

      // Close Scanner stream
      input.close();
   }
}
