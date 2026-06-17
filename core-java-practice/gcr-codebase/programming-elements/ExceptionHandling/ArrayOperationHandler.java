// Program 4: Multiple Catch Blocks - Array Operations
import java.util.Scanner;

class ArrayOperationHandler {

    // Method to retrieve and print value at given index
    // Handles ArrayIndexOutOfBoundsException and NullPointerException
    public static void getValueAtIndex(int[] array, int index) {
        try {
            int value = array[index]; // May throw exceptions
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array (enter -1 for a null array): ");
        int size = sc.nextInt();

        int[] numbers;
        if (size == -1) {
            // Demonstrate NullPointerException case
            numbers = null;
        } else {
            numbers = new int[size];
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                numbers[i] = sc.nextInt();
            }
        }

        System.out.print("Enter the index to retrieve: ");
        int index = sc.nextInt();

        // Attempt to retrieve the value
        getValueAtIndex(numbers, index);

        sc.close();
    }
}
