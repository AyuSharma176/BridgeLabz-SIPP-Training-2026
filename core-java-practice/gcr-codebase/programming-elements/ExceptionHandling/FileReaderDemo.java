// Program 1: Checked Exception (Compile-time Exception) - Reading a file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileReaderDemo {

    // Method to read and display contents of a file
    // Handles IOException (checked exception) with try-catch
    public static void readFileContents(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("--- File Contents ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Checked exception - must be handled or declared
            System.out.println("File not found");
        } finally {
            // Close the reader if it was opened
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file");
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "data.txt";

        // Attempt to read the file
        readFileContents(fileName);
    }
}
