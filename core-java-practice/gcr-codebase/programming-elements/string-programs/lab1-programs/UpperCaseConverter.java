// Program 9: Convert text to uppercase and compare with built-in toUpperCase()
import java.util.Scanner;

class UpperCaseConverter {

    // Method to convert text to uppercase using charAt() and ASCII logic
    // ASCII: 'a' = 97, 'A' = 65 → difference is 32
    public static String convertToUpperCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Check if character is a lowercase letter (between 'a' and 'z')
            if (ch >= 'a' && ch <= 'z') {
                // Subtract 32 from ASCII value to convert to uppercase
                result += (char) (ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    // Method to compare two strings using charAt() and return boolean result
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Take user input for the complete text (including spaces)
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Convert to uppercase using user-defined method
        String userDefinedUpperCase = convertToUpperCase(text);

        // Convert to uppercase using built-in toUpperCase() method
        String builtInUpperCase = text.toUpperCase();

        // Compare the two uppercase strings
        boolean areEqual = compareStrings(userDefinedUpperCase, builtInUpperCase);

        // Display results
        System.out.println("\n--- Uppercase Conversion Results ---");
        System.out.println("Original Text                       : " + text);
        System.out.println("Uppercase using user-defined method : " + userDefinedUpperCase);
        System.out.println("Uppercase using toUpperCase() method: " + builtInUpperCase);
        System.out.println("Both results are equal              : " + areEqual);

        sc.close();
    }
}
