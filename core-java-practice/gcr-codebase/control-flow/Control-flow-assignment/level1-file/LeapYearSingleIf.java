/**
 * Leap Year Checker (Single If Statement)
 * A leap year is divisible by 400 OR (divisible by 4 AND not divisible by 100)
 * This version uses a single if statement with compound conditions
 * Note: This algorithm is valid for years >= 1582 (Gregorian calendar)
 */
import java.util.Scanner;

public class LeapYearSingleIf {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get the year from user
        System.out.print("Enter Year: ");
        int year = input.nextInt();
        
        // Check leap year condition using a single if statement with compound conditions
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
        
        // Close the Scanner resource
        input.close();
    }
}