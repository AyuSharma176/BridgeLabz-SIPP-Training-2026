/**
 * Leap Year Checker
 * A leap year is divisible by 400 OR (divisible by 4 AND not divisible by 100)
 * Leap years have 366 days instead of 365 days
 * Note: This algorithm is valid for years >= 1582 (Gregorian calendar)
 */
import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get the year from user
        System.out.print("Enter Year: ");
        int year = input.nextInt();
        
        // Validate that year is >= 1582 (start of Gregorian calendar)
        if (year < 1582) {
            System.out.println("Please enter a year >= 1582");
        }
        // Check if year is divisible by 400
        else if (year % 400 == 0) {
            System.out.println(year + " is a Leap Year");
        }
        // Check if year is divisible by 100 (but not 400)
        else if (year % 100 == 0) {
            System.out.println(year + " is not a Leap Year");
        }
        // Check if year is divisible by 4
        else if (year % 4 == 0) {
            System.out.println(year + " is a Leap Year");
        }
        // Otherwise, it's not a leap year
        else {
            System.out.println(year + " is not a Leap Year");
        }
        
        // Close the Scanner resource
        input.close();
    }
}