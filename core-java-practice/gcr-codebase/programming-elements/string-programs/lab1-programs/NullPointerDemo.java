// Program 4: Demonstrate NullPointerException
class NullPointerDemo {

    // Method to GENERATE NullPointerException (unhandled - will crash)
    public static void generateNullPointerException() {
        String text = null;
        System.out.println("Calling length() on a null String...");
        // This will throw NullPointerException at runtime
        int length = text.length();
        System.out.println("Length: " + length); // This line will never execute
    }

    // Method to HANDLE NullPointerException using try-catch
    public static void handleNullPointerException() {
        String text = null;
        System.out.println("\nDemonstrating NullPointerException with try-catch...");
        try {
            int length = text.length(); // This will throw NullPointerException
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught!");
            System.out.println("Message : " + e.getMessage());
            System.out.println("Cause   : Tried to call a method on a null reference.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed - program continues safely.");
        }
    }

    public static void main(String[] args) {
        // First: call the method that handles the exception
        System.out.println("=== Handling NullPointerException ===");
        handleNullPointerException();

        // Second: call the method that generates the exception (uncomment to see crash)
        // WARNING: Uncommenting the lines below will crash the program!
        System.out.println("\n=== Generating NullPointerException (Unhandled) ===");
        System.out.println("(Uncomment generateNullPointerException() in main to see the crash)");
        // generateNullPointerException(); // Uncomment this to see the unhandled crash
    }
}
