/**
 * Harshad Number Checker
 * A Harshad number (also known as Niven number) is a positive integer that is divisible by the sum of its digits.
 * Example: 18 is a Harshad number because 18 is divisible by (1 + 8 = 9)
 */
import java.util.Scanner;

public class HarshadNumberChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get the number from user
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        // Calculate the sum of digits
        int temp = number;
        int sumOfDigits = 0;
        
        while (temp != 0) {
            // Extract the last digit
            sumOfDigits += temp % 10;
            // Remove the last digit
            temp /= 10;
        }
        
        // Check if the number is divisible by the sum of its digits
        if (number % sumOfDigits == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is Not a Harshad Number");
        }
        
        // Close the Scanner resource
        input.close();
    }
}