// Program 10: Convert text to lowercase and compare with built-in toLowerCase()
import java.util.Scanner;

class LowerCaseConverter {

    // Method to convert text to lowercase using charAt() and ASCII logic
    // ASCII: 'A' = 65, 'a' = 97 → difference is 32
    public static String convertToLowerCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Check if character is an uppercase letter (between 'A' and 'Z')
            if (ch >= 'A' && ch <= 'Z') {
                // Add 32 to ASCII value to convert to lowercase
                result += (char) (ch + 32);
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

        // Convert to lowercase using user-defined method
        String userDefinedLowerCase = convertToLowerCase(text);

        // Convert to lowercase using built-in toLowerCase() method
        String builtInLowerCase = text.toLowerCase();

        // Compare the two lowercase strings
        boolean areEqual = compareStrings(userDefinedLowerCase, builtInLowerCase);

        // Display results
        System.out.println("\n--- Lowercase Conversion Results ---");
        System.out.println("Original Text                       : " + text);
        System.out.println("Lowercase using user-defined method : " + userDefinedLowerCase);
        System.out.println("Lowercase using toLowerCase() method: " + builtInLowerCase);
        System.out.println("Both results are equal              : " + areEqual);

        sc.close();
    }
}
