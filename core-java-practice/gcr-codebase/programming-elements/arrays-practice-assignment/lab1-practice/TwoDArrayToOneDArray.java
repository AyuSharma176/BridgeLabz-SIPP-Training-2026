// TwoDArrayToOneDArray - Copies a 2D array (matrix) into a 1D array
import java.util.Scanner;

class TwoDArrayToOneDArray {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Take user input for rows and columns
      System.out.print("Enter number of rows: ");
      int rows = input.nextInt();

      System.out.print("Enter number of columns: ");
      int columns = input.nextInt();

      // Validate rows and columns are positive integers
      if (rows <= 0 || columns <= 0) {
         System.err.println("Invalid input. Rows and columns must be positive integers.");
         System.exit(0);
      }

      // Create a 2D array (matrix) based on user-defined rows and columns
      int[][] matrix = new int[rows][columns];

      // Take user input for all elements of the 2D matrix
      System.out.println("Enter the elements of the " + rows + "x" + columns + " matrix:");
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            System.out.print("matrix[" + i + "][" + j + "]: ");
            matrix[i][j] = input.nextInt();
         }
      }

      // Create a 1D array of size rows * columns to store all matrix elements
      int[] array = new int[rows * columns];

      // Define index variable to track current position in 1D array
      int index = 0;

      // Use nested for loop to copy every element from 2D array to 1D array
      for (int i = 0; i < matrix.length; i++) {
         // Inner loop accesses each element in the current row
         for (int j = 0; j < matrix[i].length; j++) {
            // Copy 2D array element to 1D array and increment index
            array[index] = matrix[i][j];
            index++;
         }
      }

      // Display the original 2D matrix
      System.out.println("\nOriginal 2D Matrix:");
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }

      // Display the resulting 1D array
      System.out.println("\nCopied 1D Array:");
      for (int i = 0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
      System.out.println();

      // Close Scanner stream
      input.close();
   }
}
