// Program 6: Find vowels and consonants and display character type in a tabular format
import java.util.Scanner;

class VowelConsonantClassifier {

    // Method to check if a character is a vowel, consonant, or not a letter
    public static String checkCharacterType(char ch) {
        // Convert to lowercase using ASCII logic if it's an uppercase letter
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to return a 2D array of character and its type
    // Each row: [character, type]
    public static String[][] getCharacterTypeArray(String text) {
        String[][] charTypeArray = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            charTypeArray[i][0] = String.valueOf(text.charAt(i));
            charTypeArray[i][1] = checkCharacterType(text.charAt(i));
        }
        return charTypeArray;
    }

    // Method to display the 2D array in a tabular format
    public static void displayCharacterTypeTable(String[][] charTypeArray) {
        System.out.println("\n--- Character Type Table ---");
        System.out.printf("%-5s %-12s %-15s%n", "No.", "Character", "Type");
        System.out.println("--------------------------------");
        for (int i = 0; i < charTypeArray.length; i++) {
            String character = charTypeArray[i][0];
            String type = charTypeArray[i][1];
            System.out.printf("%-5d %-12s %-15s%n", (i + 1), character, type);
        }
    }

    public static void main(String[] args) {
        // Take user input for the text
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Get 2D array of character and type
        String[][] charTypeArray = getCharacterTypeArray(text);

        // Display the tabular result
        displayCharacterTypeTable(charTypeArray);

        sc.close();
    }
}
