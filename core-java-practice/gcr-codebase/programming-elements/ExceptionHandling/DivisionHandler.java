// Program 2: Unchecked Exception (Runtime Exception) - Division of two numbers
import java.util.InputMismatchException;
import java.util.Scanner;

class DivisionHandler {

    // Method to divide two numbers and handle possible exceptions
    public static void divideNumbers(Scanner sc) {
        try {
            System.out.print("Enter the numerator: ");
            int numerator = sc.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = sc.nextInt();

            // This will throw ArithmeticException if denominator is 0
            int result = numerator / denominator;

            System.out.println("Result of division: " + result);

        } catch (ArithmeticException e) {
            // Unchecked exception - division by zero
            System.out.println("Error: Division by zero is not allowed!");
        } catch (InputMismatchException e) {
            // Unchecked exception - non-numeric input entered
            System.out.println("Error: Please enter valid numeric values!");
            sc.nextLine(); // Clear the invalid input from the scanner buffer
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        divideNumbers(sc);

        sc.close();
    }
}
