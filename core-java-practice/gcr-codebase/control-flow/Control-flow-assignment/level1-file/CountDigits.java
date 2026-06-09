/**
 * Count Digits in a Number
 * This program counts the total number of digits in a given positive integer
 * Example: The number 12345 has 5 digits
 */
import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get the number from user
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        // Counter to store the digit count
        int digitCount = 0;
        
        // Loop until the number becomes 0
        while (number != 0) {
            // Remove the last digit by dividing by 10
            number /= 10;
            // Increment the digit count
            digitCount++;
        }
        
        // Display the total number of digits
        System.out.println("Total number of digits: " + digitCount);
        
        // Close the Scanner resource
        input.close();
    }
}