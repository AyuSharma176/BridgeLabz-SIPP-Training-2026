// Program 5: try-with-resources (Auto-closing Resources) - Reading first line of a file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TryWithResourcesDemo {

    // Method to read the first line of a file using try-with-resources
    // The BufferedReader is automatically closed after the try block
    public static void readFirstLine(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("The file is empty.");
            }
        } catch (IOException e) {
            // Checked exception - file not found or read error
            System.out.println("Error reading file");
        }
        // No need for a finally block - the resource auto-closes here
    }

    public static void main(String[] args) {
        String fileName = "info.txt";

        readFirstLine(fileName);
    }
}
