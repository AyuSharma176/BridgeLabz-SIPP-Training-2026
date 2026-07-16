/**
 * Q2: Find the Rotation Point in a Rotated Sorted Array
 *
 * Problem  : Given a rotated sorted array, find the index of the
 *            smallest element (the rotation point) using Binary Search.
 *
 * Approach :
 *   1. left = 0, right = n - 1
 *   2. mid  = (left + right) / 2
 *      - arr[mid] > arr[right]  => smallest is in the RIGHT half  => left  = mid + 1
 *      - arr[mid] < arr[right]  => smallest is in the LEFT  half  => right = mid
 *   3. Stop when left == right  =>  arr[left] is the rotation point.
 *
 * Time Complexity  : O(log n)
 * Space Complexity : O(1)
 */
public class Q2_FindRotationPoint {

    /**
     * Returns the INDEX of the smallest element in a rotated sorted array.
     *
     * @param arr rotated sorted array (distinct elements)
     * @return index of the minimum / rotation point
     */
    public static int findRotationPoint(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array must not be empty.");

        int left = 0, right = arr.length - 1;

        // If array is not rotated (already sorted)
        if (arr[left] <= arr[right]) return 0;

        while (left < right) {
            int mid = left + (right - left) / 2;   // safe midpoint

            if (arr[mid] > arr[right]) {
                // Pivot/minimum lies in the RIGHT half
                left = mid + 1;
            } else {
                // Pivot/minimum lies in the LEFT half (mid could be the answer)
                right = mid;
            }
        }

        return left;    // left == right  =>  rotation point index
    }

    // ---------------------------------------------------------------
    // Helper: print array with index annotations
    // ---------------------------------------------------------------
    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println("  Array  : " + sb);
    }

    // ---------------------------------------------------------------
    // Main – test with multiple cases
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Q2: Find the Rotation Point (Minimum Element)");
        System.out.println("=================================================\n");

        int[][] testCases = {
            {4, 5, 6, 7, 0, 1, 2},    // rotated at index 4 -> min = 0
            {3, 4, 5, 1, 2},           // rotated at index 3 -> min = 1
            {11, 13, 15, 17},          // not rotated        -> min = 11
            {2, 1},                     // rotated at index 1 -> min = 1
            {1},                        // single element     -> min = 1
            {6, 7, 8, 9, 1, 2, 3, 4, 5} // rotated at index 4 -> min = 1
        };

        for (int t = 0; t < testCases.length; t++) {
            int[] arr = testCases[t];
            int rotIdx  = findRotationPoint(arr);

            System.out.printf("Test Case %d:%n", t + 1);
            printArray(arr);
            System.out.printf("  Rotation point index : %d%n", rotIdx);
            System.out.printf("  Minimum value        : %d%n%n", arr[rotIdx]);
        }
    }
}
