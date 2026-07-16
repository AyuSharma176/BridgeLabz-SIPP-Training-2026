/**
 * Q4: Search for a Target Value in a 2D Sorted Matrix
 *
 * Problem  : Each row is sorted in ascending order, and the first element
 *            of each row is greater than the last element of the previous row.
 *            Find whether a target value exists in the matrix.
 *
 * Approach : Treat the matrix as a flattened 1-D sorted array.
 *   1. left = 0,  right = rows * cols - 1
 *   2. mid index -> row = mid / numCols,  col = mid % numCols
 *   3. Standard binary search comparison:
 *      - match  => return true
 *      - target < matrix[row][col]  => right = mid - 1
 *      - target > matrix[row][col]  => left  = mid + 1
 *   4. Return false if not found.
 *
 * Time Complexity  : O(log(rows * cols))
 * Space Complexity : O(1)
 */
public class Q4_Search2DMatrix {

    /**
     * Search for target in a row-wise and globally sorted 2-D matrix.
     *
     * @param matrix 2-D sorted matrix
     * @param target value to find
     * @return true if target is present, false otherwise
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows    = matrix.length;
        int cols    = matrix[0].length;
        int left    = 0;
        int right   = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert flat index -> 2-D indices
            int row = mid / cols;
            int col = mid % cols;

            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left  = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // ---------------------------------------------------------------
    // Helper – print matrix
    // ---------------------------------------------------------------
    private static void printMatrix(int[][] m) {
        System.out.println("  Matrix :");
        for (int[] row : m) {
            System.out.print("    [");
            for (int j = 0; j < row.length; j++) {
                System.out.printf("%4d", row[j]);
                if (j < row.length - 1) System.out.print(",");
            }
            System.out.println("  ]");
        }
    }

    // ---------------------------------------------------------------
    // Main – test cases
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Q4: Binary Search in a 2D Sorted Matrix");
        System.out.println("=================================================\n");

        // Test 1
        int[][] matrix1 = {
            {1,  3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int[] targets1 = {3, 13, 60, 0};

        printMatrix(matrix1);
        System.out.println();
        for (int t : targets1) {
            System.out.printf("  Target %2d  =>  %s%n", t,
                    searchMatrix(matrix1, t) ? "FOUND ✓" : "NOT FOUND ✗");
        }

        System.out.println();

        // Test 2
        int[][] matrix2 = {
            {1,  1}
        };
        System.out.println();
        printMatrix(matrix2);
        System.out.println();
        for (int t : new int[]{0, 1, 2}) {
            System.out.printf("  Target %2d  =>  %s%n", t,
                    searchMatrix(matrix2, t) ? "FOUND ✓" : "NOT FOUND ✗");
        }

        System.out.println();

        // Test 3 – larger matrix
        int[][] matrix3 = {
            {1,   4,   7,  11,  15},
            {2,   5,   8,  12,  19},
            {3,   6,   9,  16,  22},
            {10, 13,  14,  17,  24},
            {18, 21,  23,  26,  30}
        };
        int[] targets3 = {5, 20, 30, -1};
        System.out.println();
        printMatrix(matrix3);
        System.out.println();
        for (int t : targets3) {
            System.out.printf("  Target %2d  =>  %s%n", t,
                    searchMatrix(matrix3, t) ? "FOUND ✓" : "NOT FOUND ✗");
        }
    }
}
