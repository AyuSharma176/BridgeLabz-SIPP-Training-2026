// Program 2: Create a substring using charAt() and compare with built-in substring()
import java.util.Scanner;

class SubstringFinder {

    // Method to create a substring using charAt() with start and end index
    public static String createSubstring(String text, int startIndex, int endIndex) {
        String result = "";
        for (int i = startIndex; i < endIndex; i++) {
            result += text.charAt(i);
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
        // Take user input for string, start and end index
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int startIndex = sc.nextInt();
        System.out.print("Enter end index: ");
        int endIndex = sc.nextInt();

        // Get substring using user-defined method
        String userDefinedSubstring = createSubstring(text, startIndex, endIndex);

        // Get substring using built-in substring() method
        String builtInSubstring = text.substring(startIndex, endIndex);

        // Compare the two substrings
        boolean areEqual = compareStrings(userDefinedSubstring, builtInSubstring);

        // Display results
        System.out.println("\n--- Substring Results ---");
        System.out.println("Substring using charAt() method  : " + userDefinedSubstring);
        System.out.println("Substring using substring() method: " + builtInSubstring);
        System.out.println("Both substrings are equal         : " + areEqual);

        sc.close();
    }
}
