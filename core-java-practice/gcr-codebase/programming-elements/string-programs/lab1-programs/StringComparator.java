// Program 1: Compare two strings using charAt() method and verify with equals()
import java.util.Scanner;

class StringComparator {

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
        // Take user input for two strings
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Compare using user-defined method
        boolean userDefinedResult = compareStrings(str1, str2);

        // Compare using built-in equals() method
        boolean builtInResult = str1.equals(str2);

        // Display results
        System.out.println("\n--- Comparison Results ---");
        System.out.println("Result using charAt() method : " + userDefinedResult);
        System.out.println("Result using equals() method : " + builtInResult);
        System.out.println("Both methods give same result : " + (userDefinedResult == builtInResult));

        sc.close();
    }
}
