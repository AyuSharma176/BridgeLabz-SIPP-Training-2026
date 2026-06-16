// Program 7: Trim leading and trailing spaces from a string using charAt()
import java.util.Scanner;

class StringTrimmer {

    // Method to find start and end indexes after trimming spaces using charAt()
    // Returns int array: [startIndex, endIndex]
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces — move start forward while space
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces — move end backward while space
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1}; // end + 1 to use as exclusive index
    }

    // Method to create a substring using charAt() with start and end index
    public static String createSubstring(String text, int startIndex, int endIndex) {
        String result = "";
        for (int i = startIndex; i < endIndex; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
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
        // Take user input (with leading/trailing spaces)
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text (with leading/trailing spaces): ");
        String text = sc.nextLine();

        // Get trim indexes using user-defined method
        int[] trimIndexes = findTrimIndexes(text);
        int startIndex = trimIndexes[0];
        int endIndex = trimIndexes[1];

        // Get trimmed string using user-defined substring method
        String userDefinedTrimmed = createSubstring(text, startIndex, endIndex);

        // Get trimmed string using built-in trim() method
        String builtInTrimmed = text.trim();

        // Compare the two trimmed strings
        boolean areEqual = compareStrings(userDefinedTrimmed, builtInTrimmed);

        // Display results
        System.out.println("\n--- String Trim Results ---");
        System.out.println("Original Text (with quotes)         : \"" + text + "\"");
        System.out.println("Trimmed using user-defined method   : \"" + userDefinedTrimmed + "\"");
        System.out.println("Trimmed using built-in trim() method: \"" + builtInTrimmed + "\"");
        System.out.println("Both results are equal              : " + areEqual);

        sc.close();
    }
}
