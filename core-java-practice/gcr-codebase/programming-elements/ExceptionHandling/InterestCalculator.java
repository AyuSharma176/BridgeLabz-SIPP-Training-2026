// Program 6: throw vs. throws (Exception Propagation) - Interest Calculation
import java.util.Scanner;

class InterestCalculator {

    // Method that THROWS IllegalArgumentException using 'throw'
    // and propagates it to the caller using 'throws' in the method signature
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            // 'throw' keyword - actually creates and throws the exception object
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        // Simple Interest formula: SI = (P * R * T) / 100
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter rate of interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        // Caller handles the exception propagated via 'throws'
        try {
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
