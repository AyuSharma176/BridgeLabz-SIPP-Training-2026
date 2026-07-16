/**
 * Q5: Find the First and Last Occurrence of an Element in a Sorted Array
 *
 * Problem  : Given a sorted array and a target, find both the first and
 *            last index at which target appears. Return {-1, -1} if absent.
 *
 * Approach :
 *   FIRST OCCURRENCE
 *     - Regular binary search; when arr[mid] == target, record mid and
 *       continue LEFT  (right = mid - 1) to find the earliest match.
 *
 *   LAST OCCURRENCE
 *     - Same idea; when arr[mid] == target, record mid and continue RIGHT
 *       (left = mid + 1) to find the latest match.
 *
 * Time Complexity  : O(log n) – two separate binary searches
 * Space Complexity : O(1)
 */
public class Q5_FirstLastOccurrence {

    /**
     * Find the FIRST index where target appears.
     *
     * @param arr    sorted array (may contain duplicates)
     * @param target value to search
     * @return first index, or -1 if not found
     */
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;       // potential first occurrence
                right  = mid - 1;  // keep searching LEFT for earlier one
            } else if (arr[mid] < target) {
                left  = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /**
     * Find the LAST index where target appears.
     *
     * @param arr    sorted array (may contain duplicates)
     * @param target value to search
     * @return last index, or -1 if not found
     */
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;       // potential last occurrence
                left   = mid + 1;  // keep searching RIGHT for a later one
            } else if (arr[mid] < target) {
                left  = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /**
     * Returns {firstIndex, lastIndex} of target in arr.
     * Returns {-1, -1} if target is not found.
     */
    public static int[] searchRange(int[] arr, int target) {
        return new int[]{findFirst(arr, target), findLast(arr, target)};
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

    // ---------------------------------------------------------------
    // Main – test cases
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Q5: First and Last Occurrence (Binary Search)");
        System.out.println("=================================================\n");

        // {array, target}
        int[][] arrays = {
            {5, 7, 7, 8, 8, 10},
            {5, 7, 7, 8, 8, 10},
            {1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5},
            {2, 2},
            {}
        };
        int[] targets = {8, 6, 1, 3, 2, 0};

        for (int t = 0; t < arrays.length; t++) {
            int[]   arr    = arrays[t];
            int     target = targets[t];
            int[]   range  = searchRange(arr, target);

            System.out.printf("Test Case %d:%n", t + 1);
            printArray(arr);
            System.out.printf("  Target         : %d%n", target);
            System.out.printf("  First index    : %d%n", range[0]);
            System.out.printf("  Last  index    : %d%n", range[1]);

            if (range[0] == -1) {
                System.out.printf("  Result         : Element NOT found in array%n%n");
            } else {
                int count = range[1] - range[0] + 1;
                System.out.printf("  Occurrences    : %d%n%n", count);
            }
        }
    }
}
