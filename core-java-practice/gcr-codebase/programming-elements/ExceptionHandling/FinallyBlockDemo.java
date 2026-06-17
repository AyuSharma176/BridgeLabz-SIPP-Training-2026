// Program 7: finally Block Execution - Integer Division
import java.util.Scanner;

class FinallyBlockDemo {

    // Method to perform integer division and demonstrate finally block execution
    public static void performDivision(int numerator, int denominator) {
        try {
            int result = numerator / denominator; // May throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } finally {
            // This block always executes, regardless of exception or not
            System.out.println("Operation completed");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the numerator: ");
        int numerator = sc.nextInt();

        System.out.print("Enter the denominator: ");
        int denominator = sc.nextInt();

        performDivision(numerator, denominator);

        sc.close();
    }
}
