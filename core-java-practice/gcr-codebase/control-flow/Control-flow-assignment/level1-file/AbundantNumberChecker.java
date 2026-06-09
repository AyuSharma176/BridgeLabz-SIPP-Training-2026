/**
 * Abundant Number Checker
 * A number is an abundant number if the sum of its proper divisors (divisors excluding the number itself) is greater than the number.
 * Example: 12 is an abundant number because 1 + 2 + 3 + 4 + 6 = 16, which is greater than 12
 */
import java.util.Scanner;

public class AbundantNumberChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get the number from user
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        // Calculate the sum of all proper divisors
        int sumOfDivisors = 0;
        for (int i = 1; i < number; i++) {
            // Check if i is a divisor of the given number
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }
        
        // Check if the number is an abundant number
        if (sumOfDivisors > number) {
            System.out.println(number + " is an Abundant Number");
        } else {
            System.out.println(number + " is Not an Abundant Number");
        }
        
        // Close the Scanner resource
        input.close();
    }
}