// Program 8: Demonstrate ArrayIndexOutOfBoundsException
import java.util.Scanner;

class ArrayIndexOutOfBoundsDemo {

    // Method to GENERATE ArrayIndexOutOfBoundsException (unhandled - will crash)
    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println("Accessing index beyond the length of the array...");
        // Accessing index equal to array length causes ArrayIndexOutOfBoundsException
        String name = names[names.length]; // Invalid index - will crash
        System.out.println("Name: " + name); // This line will never execute
    }

    // Method to HANDLE ArrayIndexOutOfBoundsException using try-catch
    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        System.out.println("\nDemonstrating ArrayIndexOutOfBoundsException with try-catch...");
        try {
            String name = names[names.length]; // Invalid index - throws exception
            System.out.println("Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught!");
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause  : Tried to access index " + names.length + " but array size is only " + names.length + ".");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed - program continues safely.");
        }
    }

    public static void main(String[] args) {
        // Take user input for the array of names
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of names: ");
        int size = sc.nextInt();
        String[] names = new String[size];

        System.out.println("Enter " + size + " names:");
        for (int i = 0; i < size; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        // Display entered names
        System.out.println("\nNames entered: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // First: call the method that handles the exception
        System.out.println("\n=== Handling ArrayIndexOutOfBoundsException ===");
        handleArrayIndexOutOfBoundsException(names);

        // Second: call the method that generates the exception (uncomment to see crash)
        // WARNING: Uncommenting the lines below will crash the program!
        System.out.println("\n=== Generating ArrayIndexOutOfBoundsException (Unhandled) ===");
        System.out.println("(Uncomment generateArrayIndexOutOfBoundsException() in main to see the crash)");
        // generateArrayIndexOutOfBoundsException(names); // Uncomment to see the unhandled crash

        sc.close();
    }
}
