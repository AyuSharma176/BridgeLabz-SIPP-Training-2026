/**
 * Day of Week Calculator
 * This program determines the day of the week for a given date using Zeller's Congruence algorithm
 * Returns: 0 = Saturday, 1 = Sunday, 2 = Monday, ..., 6 = Friday
 */
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get date components from user
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        
        System.out.print("Enter day (1-31): ");
        int day = input.nextInt();
        
        System.out.print("Enter year (e.g., 2024): ");
        int year = input.nextInt();
        
        // Apply Zeller's Congruence algorithm
        // Adjust year and month for the algorithm
        int adjustedYear = year - (14 - month) / 12;
        int centurialAdjustment = adjustedYear + adjustedYear / 4 - adjustedYear / 100 + adjustedYear / 400;
        int adjustedMonth = month + 12 * ((14 - month) / 12) - 2;
        int dayOfWeek = (day + centurialAdjustment + (31 * adjustedMonth) / 12) % 7;
        
        // Map the result to day names
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        System.out.println("Day of the week: " + days[dayOfWeek]);
        
        // Close the Scanner resource
        input.close();
    }
}