/**
 * Q1: Astronomer Star Brightness Search
 *
 * Covers:
 *  1. Standard binary search in sorted catalog  -> O(log n)
 *  2. Search in rotated catalog (telescope glitch)
 *  3. First and last occurrence of a repeated brightness value
 *  4. Find the minimum element in a rotated sorted array
 */
public class Q1_StarBrightnessSearch {

    // ---------------------------------------------------------------
    // 1. Standard Binary Search  O(log n)
    // ---------------------------------------------------------------
    /**
     * Search for a target brightness in a sorted catalog.
     *
     * @param catalog sorted array of brightness values
     * @param target  brightness value to find
     * @return index of target, or -1 if not found
     */
    public static int binarySearch(double[] catalog, double target) {
        int left = 0, right = catalog.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;   // avoids integer overflow

            if (catalog[mid] == target) return mid;
            if (catalog[mid] < target)  left  = mid + 1;
            else                        right = mid - 1;
        }
        return -1;  // not found
    }

    // ---------------------------------------------------------------
    // 2. Search in Rotated Catalog
    //    e.g.  [4, 5, 6, 7, 0, 1, 2]  <- rotated at index 4
    // ---------------------------------------------------------------
    /**
     * Binary search in a rotated sorted array (no duplicates).
     *
     * @param arr    rotated sorted array
     * @param target value to find
     * @return index of target, or -1 if not found
     */
    public static int searchRotated(double[] arr, double target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;

            // Left half is sorted
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid])
                    right = mid - 1;        // target lies in left half
                else
                    left  = mid + 1;        // target lies in right half
            }
            // Right half is sorted
            else {
                if (target > arr[mid] && target <= arr[right])
                    left  = mid + 1;        // target lies in right half
                else
                    right = mid - 1;        // target lies in left half
            }
        }
        return -1;
    }

    // ---------------------------------------------------------------
    // 3a. First Occurrence of a Repeated Brightness Value
    // ---------------------------------------------------------------
    /**
     * Find the FIRST index where target appears in a sorted array.
     *
     * @param arr    sorted array (may contain duplicates)
     * @param target value to find
     * @return first index of target, or -1
     */
    public static int firstOccurrence(double[] arr, double target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;   // record and keep searching LEFT
                right  = mid - 1;
            } else if (arr[mid] < target) {
                left  = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // ---------------------------------------------------------------
    // 3b. Last Occurrence of a Repeated Brightness Value
    // ---------------------------------------------------------------
    /**
     * Find the LAST index where target appears in a sorted array.
     *
     * @param arr    sorted array (may contain duplicates)
     * @param target value to find
     * @return last index of target, or -1
     */
    public static int lastOccurrence(double[] arr, double target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;   // record and keep searching RIGHT
                left   = mid + 1;
            } else if (arr[mid] < target) {
                left  = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // ---------------------------------------------------------------
    // 4. Find Minimum Element in a Rotated Sorted Array
    // ---------------------------------------------------------------
    /**
     * Find the minimum (rotation point) in a rotated sorted array.
     * Works in O(log n).
     *
     * @param arr rotated sorted array
     * @return minimum value
     */
    public static double findMinimum(double[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right])
                left  = mid + 1;    // min is in right half
            else
                right = mid;        // min is in left half (including mid)
        }
        return arr[left];
    }

    // ---------------------------------------------------------------
    // Main – demonstration with 10 M-entry simulation & small samples
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Q1: Astronomer Star Brightness Search");
        System.out.println("=================================================\n");

        // --- Part 1: Standard binary search on 10 M sorted entries ---
        int N = 10_000_000;
        double[] catalog = new double[N];
        for (int i = 0; i < N; i++) catalog[i] = i * 0.001;   // 0.000, 0.001, …

        double target = 5432.100;
        long t0 = System.nanoTime();
        int idx = binarySearch(catalog, target);
        long t1 = System.nanoTime();
        System.out.printf("[Part 1] Standard Binary Search%n");
        System.out.printf("  Catalog size : %,d entries%n", N);
        System.out.printf("  Target       : %.3f%n", target);
        System.out.printf("  Found at idx : %d%n", idx);
        System.out.printf("  Time taken   : %.3f ms%n%n", (t1 - t0) / 1e6);

        // --- Part 2: Rotated catalog ---
        double[] rotated = {5.5, 6.0, 7.2, 8.1, 1.0, 2.3, 3.7, 4.4};
        double rTarget = 2.3;
        System.out.println("[Part 2] Search in Rotated Catalog");
        System.out.printf("  Array  : [5.5, 6.0, 7.2, 8.1, 1.0, 2.3, 3.7, 4.4]%n");
        System.out.printf("  Target : %.1f  ->  index %d%n%n", rTarget,
                           searchRotated(rotated, rTarget));

        // --- Part 3: First & last occurrence ---
        double[] repeated = {1.0, 2.5, 2.5, 2.5, 3.0, 4.0, 4.0, 5.5};
        double rep = 2.5;
        System.out.println("[Part 3] First & Last Occurrence of Repeated Value");
        System.out.printf("  Array  : [1.0, 2.5, 2.5, 2.5, 3.0, 4.0, 4.0, 5.5]%n");
        System.out.printf("  Target : %.1f%n", rep);
        System.out.printf("  First occurrence : index %d%n", firstOccurrence(repeated, rep));
        System.out.printf("  Last  occurrence : index %d%n%n", lastOccurrence(repeated, rep));

        // --- Part 4: Minimum in rotated array ---
        double[] rot2 = {4.0, 5.5, 6.1, 7.3, 1.2, 2.8, 3.3};
        System.out.println("[Part 4] Find Minimum in Rotated Array");
        System.out.printf("  Array   : [4.0, 5.5, 6.1, 7.3, 1.2, 2.8, 3.3]%n");
        System.out.printf("  Minimum : %.1f%n%n", findMinimum(rot2));
    }
}
