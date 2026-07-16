/**
 * Q3: Find a Peak Element in an Array
 *
 * Problem  : A peak element is greater than both its neighbors.
 *            Find any one peak element using Binary Search.
 *
 * Approach :
 *   1. left = 0, right = n - 1
 *   2. mid  = (left + right) / 2
 *      - arr[mid] > arr[mid-1]  AND  arr[mid] > arr[mid+1]  => peak found
 *      - arr[mid] < arr[mid-1]                               => search LEFT  (right = mid - 1)
 *      - arr[mid] < arr[mid+1]                               => search RIGHT (left  = mid + 1)
 *   3. Handle boundary: treat out-of-bound neighbors as -INFINITY.
 *
 * Time Complexity  : O(log n)
 * Space Complexity : O(1)
 */
public class Q3_FindPeakElement {

    /**
     * Returns the INDEX of any peak element.
     * Boundary elements are peaks if they exceed their single neighbor.
     *
     * @param arr input array
     * @return index of a peak element
     */
    public static int findPeak(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array must not be empty.");

        int n     = arr.length;
        int left  = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Treat out-of-bound as -∞
            int leftVal  = (mid > 0)     ? arr[mid - 1] : Integer.MIN_VALUE;
            int rightVal = (mid < n - 1) ? arr[mid + 1] : Integer.MIN_VALUE;

            if (arr[mid] >= leftVal && arr[mid] >= rightVal) {
                // Both neighbors are smaller => peak found
                return mid;
            } else if (arr[mid] < leftVal) {
                // Left neighbor is larger; a peak must exist on the LEFT side
                right = mid - 1;
            } else {
                // Right neighbor is larger; a peak must exist on the RIGHT side
                left = mid + 1;
            }
        }

        return -1;  // Should never reach here for a valid non-empty array
    }

    // ---------------------------------------------------------------
    // Helper
    // ---------------------------------------------------------------
    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        System.out.println("  Array  : " + sb + "]");
    }

    private static boolean verifyPeak(int[] arr, int idx) {
        int n        = arr.length;
        int leftVal  = (idx > 0)     ? arr[idx - 1] : Integer.MIN_VALUE;
        int rightVal = (idx < n - 1) ? arr[idx + 1] : Integer.MIN_VALUE;
        return arr[idx] >= leftVal && arr[idx] >= rightVal;
    }

    // ---------------------------------------------------------------
    // Main – test cases
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Q3: Find Peak Element Using Binary Search");
        System.out.println("=================================================\n");

        int[][] testCases = {
            {1, 3, 20, 4, 1, 0},    // peak = 20 at index 2
            {10, 20, 15, 2, 23, 90, 67}, // multiple peaks; any valid answer OK
            {1, 2, 3, 4, 5},        // peak at last element (index 4)
            {5, 4, 3, 2, 1},        // peak at first element (index 0)
            {1},                     // single element is always a peak
            {1, 3, 2}               // peak = 3 at index 1
        };

        for (int t = 0; t < testCases.length; t++) {
            int[] arr   = testCases[t];
            int peakIdx = findPeak(arr);

            System.out.printf("Test Case %d:%n", t + 1);
            printArray(arr);
            System.out.printf("  Peak index   : %d%n", peakIdx);
            System.out.printf("  Peak value   : %d%n", arr[peakIdx]);
            System.out.printf("  Verified     : %s%n%n", verifyPeak(arr, peakIdx) ? "PASS ✓" : "FAIL ✗");
        }
    }
}
