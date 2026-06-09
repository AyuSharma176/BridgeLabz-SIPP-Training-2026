/**
 * Prime Number Checker
 * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * Example: 2, 3, 5, 7, 11, 13 are prime numbers
 */
import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get the number from user
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        // Assume the number is prime initially
        boolean isPrime = true;
        
        // Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            isPrime = false;
        } else {
            // Check for divisors from 2 to number - 1
            for (int i = 2; i < number && isPrime; i++) {
                // If number is divisible by i, it's not prime
                if (number % i == 0) {
                    isPrime = false;
                }
            }
        }
        
        // Display the result
        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is Not a Prime Number");
        }
        
        // Close the Scanner resource
        input.close();
    }
}