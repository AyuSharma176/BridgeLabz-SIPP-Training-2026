/**
 * Armstrong Number Checker
 * An Armstrong number (also called a narcissistic number) is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
 * Example: 153 is an Armstrong number because 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
 */
import java.util.Scanner;

public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get the number from user
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        // Calculate the sum of cubes of digits
        int temp = number;
        int sumOfCubes = 0;
        
        while (temp != 0) {
            int digit = temp % 10;
            // Add the cube of the digit to the sum
            sumOfCubes += digit * digit * digit;
            // Remove the last digit
            temp /= 10;
        }
        
        // Check if the number is an Armstrong number
        if (sumOfCubes == number) {
            System.out.println(number + " is an Armstrong Number");
        } else {
            System.out.println(number + " is Not an Armstrong Number");
        }
        
        // Close the Scanner resource
        input.close();
    }
}