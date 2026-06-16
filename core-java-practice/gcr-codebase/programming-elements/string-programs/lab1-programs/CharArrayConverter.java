// Program 3: Return all characters using user-defined method and compare with toCharArray()
import java.util.Scanner;

class CharArrayConverter {

    // Method to return all characters in a string without using toCharArray()
    public static char[] getCharArray(String text) {
        char[] charArray = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            charArray[i] = text.charAt(i);
        }
        return charArray;
    }

    // Method to compare two char arrays and return a boolean result
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Take user input for the text
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Get char array using user-defined method
        char[] userDefinedArray = getCharArray(text);

        // Get char array using built-in toCharArray() method
        char[] builtInArray = text.toCharArray();

        // Compare the two char arrays
        boolean areEqual = compareCharArrays(userDefinedArray, builtInArray);

        // Display results
        System.out.println("\n--- Char Array Results ---");
        System.out.print("Char array using user-defined method : ");
        for (char c : userDefinedArray) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.print("Char array using toCharArray() method: ");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("Both arrays are equal                : " + areEqual);

        sc.close();
    }
}
