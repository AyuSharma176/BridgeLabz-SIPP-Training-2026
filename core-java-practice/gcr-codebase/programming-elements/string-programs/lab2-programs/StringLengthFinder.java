// Program 1: Find the length of a string without using the length() method
import java.util.Scanner;

class StringLengthFinder {

    // Method to find the length of a string without using length()
    // Logic: use infinite loop with charAt() until it throws StringIndexOutOfBoundsException
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // Throws exception when index exceeds length
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception means we've gone past the last character
        }
        return count;
    }

    public static void main(String[] args) {
        // Take user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Find length using user-defined method
        int userDefinedLength = findLength(text);

        // Find length using built-in length() method
        int builtInLength = text.length();

        // Display results
        System.out.println("\n--- String Length Results ---");
        System.out.println("String                              : " + text);
        System.out.println("Length using user-defined method    : " + userDefinedLength);
        System.out.println("Length using built-in length() method: " + builtInLength);
        System.out.println("Both results are equal              : " + (userDefinedLength == builtInLength));

        sc.close();
    }
}
