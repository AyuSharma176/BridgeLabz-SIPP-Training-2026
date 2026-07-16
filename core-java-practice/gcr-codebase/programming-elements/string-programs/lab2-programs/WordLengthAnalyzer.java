// Program 3: Split text into words and return words with their lengths in a 2D array
import java.util.Scanner;

class WordLengthAnalyzer {

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

    // Method to split text into words using charAt()
    public static String[] splitIntoWords(String text) {
        int textLength = findLength(text);

        // Count words
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

        // Extract words
        String[] words = new String[wordCount];
        int wordIndex = 0;
        int charStart = -1;

        for (int i = 0; i <= textLength; i++) {
            boolean isSpace = (i == textLength) || (text.charAt(i) == ' ');
            if (!isSpace && charStart == -1) {
                charStart = i;
            } else if (isSpace && charStart != -1) {
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

    // Method to return a 2D array of word and its corresponding length
    // Each row: [word, lengthAsString]
    public static String[][] getWordLengthArray(String[] words) {
        String[][] wordLengthArray = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLengthArray[i][0] = words[i];
            wordLengthArray[i][1] = String.valueOf(findLength(words[i]));
        }
        return wordLengthArray;
    }

    public static void main(String[] args) {
        // Take user input for complete text
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Split into words
        String[] words = splitIntoWords(text);

        // Get 2D array of word and length
        String[][] wordLengthArray = getWordLengthArray(words);

        // Display results in tabular format
        System.out.println("\n--- Word and Length Table ---");
        System.out.printf("%-5s %-20s %-10s%n", "No.", "Word", "Length");
        System.out.println("-------------------------------------");
        for (int i = 0; i < wordLengthArray.length; i++) {
            String word = wordLengthArray[i][0];
            // Convert length from String to Integer for display
            int length = Integer.parseInt(wordLengthArray[i][1]);
            System.out.printf("%-5d %-20s %-10d%n", (i + 1), word, length);
        }

        sc.close();
    }
}
