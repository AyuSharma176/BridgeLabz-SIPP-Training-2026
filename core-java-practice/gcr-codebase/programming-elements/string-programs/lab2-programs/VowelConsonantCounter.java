// Program 5: Find vowels and consonants in a string and display the count
import java.util.Scanner;

class VowelConsonantCounter {

    // Method to check if a character is a vowel, consonant, or not a letter
    // Returns: "Vowel", "Consonant", or "Not a Letter"
    public static String checkCharacterType(char ch) {
        // Convert to lowercase using ASCII logic if it's an uppercase letter
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32); // Convert uppercase to lowercase
        }

        // Check if it's a letter first
        if (ch >= 'a' && ch <= 'z') {
            // Check if it's a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to find count of vowels and consonants using charAt()
    // Returns int array: [vowelCount, consonantCount]
    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacterType(text.charAt(i));
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }

        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        // Take user input for the text
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Get vowel and consonant counts
        int[] counts = countVowelsAndConsonants(text);
        int vowelCount = counts[0];
        int consonantCount = counts[1];

        // Display results
        System.out.println("\n--- Vowel and Consonant Count ---");
        System.out.println("Text             : " + text);
        System.out.println("Total Vowels     : " + vowelCount);
        System.out.println("Total Consonants : " + consonantCount);

        sc.close();
    }
}
