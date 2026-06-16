// Program 5: Demonstrate StringIndexOutOfBoundsException
import java.util.Scanner;

class StringIndexOutOfBoundsDemo {

    // Method to GENERATE StringIndexOutOfBoundsException (unhandled - will crash)
    public static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println("Accessing index beyond the length of the string...");
        // Accessing index equal to length will cause StringIndexOutOfBoundsException
        char ch = text.charAt(text.length()); // Invalid index - will crash
        System.out.println("Character: " + ch); // This line will never execute
    }

    // Method to HANDLE StringIndexOutOfBoundsException using try-catch
    public static void handleStringIndexOutOfBoundsException(String text) {
        System.out.println("\nDemonstrating StringIndexOutOfBoundsException with try-catch...");
        try {
            char ch = text.charAt(text.length()); // Invalid index - throws exception
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught!");
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause  : Tried to access an index beyond the string length (" + text.length() + ").");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed - program continues safely.");
        }
    }

    public static void main(String[] args) {
        // Take user input for the string
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        // First: call the method that handles the exception
        System.out.println("\n=== Handling StringIndexOutOfBoundsException ===");
        handleStringIndexOutOfBoundsException(text);

        // Second: call the method that generates the exception (uncomment to see crash)
        // WARNING: Uncommenting the lines below will crash the program!
        System.out.println("\n=== Generating StringIndexOutOfBoundsException (Unhandled) ===");
        System.out.println("(Uncomment generateStringIndexOutOfBoundsException() in main to see the crash)");
        // generateStringIndexOutOfBoundsException(text); // Uncomment to see the unhandled crash

        sc.close();
    }
}
