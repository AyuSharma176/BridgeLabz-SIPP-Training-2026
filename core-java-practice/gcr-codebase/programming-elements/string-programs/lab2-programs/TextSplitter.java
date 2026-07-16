// Program 2: Split text into words using charAt() and compare with split()
import java.util.Scanner;

class TextSplitter {

    // Method to find the length of a string without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Reached end of string
        }
        return count;
    }

    // Method to split text into words using charAt() without split()
    // Logic: Count words first, then extract each word using space indexes
    public static String[] splitIntoWords(String text) {
        int textLength = findLength(text);

        // Step 1: Count number of words (words = spaces + 1, ignoring extra spaces)
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) != ' ') {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        // Step 2: Extract words into array
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int charStart = -1;

        for (int i = 0; i <= textLength; i++) {
            boolean isSpace = (i == textLength) || (text.charAt(i) == ' ');
            if (!isSpace && charStart == -1) {
                charStart = i; // Start of a new word
            } else if (isSpace && charStart != -1) {
                // End of a word — extract it using our substring logic
                String word = "";
                for (int j = charStart; j < i; j++) {
                    word += text.charAt(j);
                }
                words[wordIndex] = word;
                wordIndex++;
                charStart = -1;
            }
        }

        return words;
    }

    // Method to compare two String arrays and return boolean
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Take user input for complete text
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Split using user-defined method
        String[] userDefinedWords = splitIntoWords(text);

        // Split using built-in split() method
        String[] builtInWords = text.trim().split("\\s+");

        // Compare the two word arrays
        boolean areEqual = compareStringArrays(userDefinedWords, builtInWords);

        // Display results
        System.out.println("\n--- Word Split Results ---");
        System.out.print("Words using user-defined method : ");
        for (String word : userDefinedWords) {
            System.out.print("[" + word + "] ");
        }

        System.out.println();
        System.out.print("Words using split() method      : ");
        for (String word : builtInWords) {
            System.out.print("[" + word + "] ");
        }

        System.out.println();
        System.out.println("Both results are equal          : " + areEqual);

        sc.close();
    }
}
