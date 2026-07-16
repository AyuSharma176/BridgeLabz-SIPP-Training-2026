// Program 9: Nested try-catch Block - Array access and division
import java.util.Scanner;

class NestedTryCatchDemo {

    // Method to access array element by index and divide it by a divisor
    // Uses nested try-catch to handle both exception types separately
    public static void accessAndDivide(int[] array, int index, int divisor) {
        try {
            // Outer try - handles ArrayIndexOutOfBoundsException
            int value = array[index];

            try {
                // Inner try - handles ArithmeticException
                int result = value / divisor;
                System.out.println("Division result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] array = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

        System.out.print("Enter the index to access: ");
        int index = sc.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = sc.nextInt();

        accessAndDivide(array, index, divisor);

        sc.close();
    }
}
