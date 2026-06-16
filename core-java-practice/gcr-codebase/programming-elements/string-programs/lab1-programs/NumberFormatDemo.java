// Program 7: Demonstrate NumberFormatException
import java.util.Scanner;

class NumberFormatDemo {

    // Method to GENERATE NumberFormatException (unhandled - will crash)
    public static void generateNumberFormatException(String text) {
        System.out.println("Calling Integer.parseInt() on non-numeric text...");
        // If text does not contain a valid number, parseInt() throws NumberFormatException
        int number = Integer.parseInt(text); // Will crash if text is not a number
        System.out.println("Parsed Number: " + number); // This line will never execute
    }

    // Method to HANDLE NumberFormatException using try-catch
    public static void handleNumberFormatException(String text) {
        System.out.println("\nDemonstrating NumberFormatException with try-catch...");
        try {
            int number = Integer.parseInt(text); // Throws NumberFormatException if not numeric
            System.out.println("Parsed Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught!");
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause  : The text \"" + text + "\" cannot be parsed as an integer.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed - program continues safely.");
        }
    }

    public static void main(String[] args) {
        // Take user input as a String
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value (try a non-numeric string like 'hello'): ");
        String text = sc.next();

        // First: call the method that handles the exception
        System.out.println("\n=== Handling NumberFormatException ===");
        handleNumberFormatException(text);

        // Second: call the method that generates the exception (uncomment to see crash)
        // WARNING: Uncommenting the lines below will crash the program!
        System.out.println("\n=== Generating NumberFormatException (Unhandled) ===");
        System.out.println("(Uncomment generateNumberFormatException() in main to see the crash)");
        // generateNumberFormatException(text); // Uncomment to see the unhandled crash

        sc.close();
    }
}
