// Program 6: Demonstrate IllegalArgumentException
import java.util.Scanner;

class IllegalArgumentDemo {

    // Method to GENERATE IllegalArgumentException (unhandled - will crash)
    public static void generateIllegalArgumentException(String text) {
        System.out.println("Calling substring() with start index greater than end index...");
        // Setting start index greater than end index causes IllegalArgumentException
        String result = text.substring(5, 2); // Invalid: start > end - will crash
        System.out.println("Substring: " + result); // This line will never execute
    }

    // Method to HANDLE IllegalArgumentException using try-catch
    public static void handleIllegalArgumentException(String text) {
        System.out.println("\nDemonstrating IllegalArgumentException with try-catch...");
        try {
            String result = text.substring(5, 2); // Invalid: start > end - throws exception
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught!");
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause  : Start index (5) is greater than end index (2) in substring().");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed - program continues safely.");
        }
    }

    public static void main(String[] args) {
        // Take user input for the string
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string (at least 6 characters for best demo): ");
        String text = sc.next();

        // First: call the method that handles the exception
        System.out.println("\n=== Handling IllegalArgumentException ===");
        handleIllegalArgumentException(text);

        // Second: call the method that generates the exception (uncomment to see crash)
        // WARNING: Uncommenting the lines below will crash the program!
        System.out.println("\n=== Generating IllegalArgumentException (Unhandled) ===");
        System.out.println("(Uncomment generateIllegalArgumentException() in main to see the crash)");
        // generateIllegalArgumentException(text); // Uncomment to see the unhandled crash

        sc.close();
    }
}
