import java.util.Random;

/**
 * Library Book Sorting - Algorithm Comparison
 * --------------------------------------------
 * A library sorts 1,000,000 books by year.
 *
 * This class implements:
 *   1. Merge Sort    -> O(n log n) guaranteed, stable
 *   2. Quick Sort    -> Lomuto partition scheme with 3-way (median-of-three) pivot selection
 *   3. Counting Sort -> for bounded categories (genre codes 1-20)
 *
 * It also runs an empirical runtime comparison on input sizes 100 / 1000 / 10000.
 */
public class LibrarySortComparison {

    // ----------------------------------------------------------------------
    // 1. MERGE SORT - O(n log n)
    // ----------------------------------------------------------------------

    /**
     * Top-level driver for merge sort.
     * Divide:  split array into two halves        -> O(log n) levels
     * Conquer: recursively sort each half
     * Combine: merge two sorted halves             -> O(n) per level
     * Total: O(n log n)
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergeSort(slice(arr, 0, mid));
        int[] right = mergeSort(slice(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] slice(int[] arr, int from, int to) {
        int[] result = new int[to - from];
        System.arraycopy(arr, from, result, 0, to - from);
        return result;
    }

    /**
     * Merge step: combines two sorted arrays into one sorted array.
     * Runs in O(n) time where n = left.length + right.length.
     * Because mergeSort makes log(n) levels of recursion, and each
     * level does O(n) total work across all merges, overall complexity
     * of mergeSort is O(n log n).
     */
    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }

        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }

    // ----------------------------------------------------------------------
    // 2. QUICK SORT - Lomuto partition with 3-way (median-of-three) pivot
    // ----------------------------------------------------------------------

    /**
     * Driver for quick sort. Sorts a copy of arr and returns it.
     * Average case: O(n log n). Worst case: O(n^2) (mitigated by
     * median-of-three pivot selection).
     */
    public static int[] quickSort(int[] arr) {
        int[] a = arr.clone();
        quickSort(a, 0, a.length - 1);
        return a;
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = lomutoPartition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    /**
     * Picks a good pivot by looking at first, middle, and last elements,
     * then moves the median of the three to the 'high' position so the
     * Lomuto partition scheme (which always uses a[high] as pivot) benefits
     * from a better pivot choice than a plain first/last element pick.
     * This is the "3-way pivot" selection strategy.
     */
    private static int medianOfThree(int[] a, int low, int high) {
        int mid = (low + high) / 2;

        if (a[low] > a[mid]) {
            swap(a, low, mid);
        }
        if (a[low] > a[high]) {
            swap(a, low, high);
        }
        if (a[mid] > a[high]) {
            swap(a, mid, high);
        }

        // move median (currently at mid) to high, keep it as the pivot
        swap(a, mid, high);
        return a[high];
    }

    /**
     * Classic Lomuto partition scheme.
     * Pivot = a[high] (chosen via median-of-three beforehand).
     * All elements <= pivot end up left of the final pivot index.
     */
    private static int lomutoPartition(int[] a, int low, int high) {
        int pivot = medianOfThree(a, low, high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }

        swap(a, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    // ----------------------------------------------------------------------
    // 3. COUNTING SORT - for bounded categories (genre codes 1-20)
    // ----------------------------------------------------------------------

    /**
     * Counting sort for a small, bounded range of integer keys.
     * Ideal for genre codes 1-20 (a fixed, small range k=20).
     * Time complexity: O(n + k) where n = number of items, k = range size.
     * Space complexity: O(n + k).
     */
    public static int[] countingSortGenres(int[] genreCodes, int minCode, int maxCode) {
        int rangeSize = maxCode - minCode + 1;
        int[] counts = new int[rangeSize];

        for (int code : genreCodes) {
            counts[code - minCode]++;
        }

        int[] sorted = new int[genreCodes.length];
        int index = 0;
        for (int offset = 0; offset < rangeSize; offset++) {
            for (int c = 0; c < counts[offset]; c++) {
                sorted[index++] = offset + minCode;
            }
        }

        return sorted;
    }

    // ----------------------------------------------------------------------
    // 4. EMPIRICAL RUNTIME COMPARISON
    // ----------------------------------------------------------------------

    private static long timeMergeSort(int[] data) {
        long start = System.nanoTime();
        mergeSort(data);
        return System.nanoTime() - start;
    }

    private static long timeQuickSort(int[] data) {
        long start = System.nanoTime();
        quickSort(data);
        return System.nanoTime() - start;
    }

    private static long timeCountingSort(int[] data) {
        long start = System.nanoTime();
        countingSortGenres(data, 1, 20);
        return System.nanoTime() - start;
    }

    /**
     * Compares Merge Sort and Quick Sort on random integer arrays
     * of the given sizes. Counting Sort is compared separately using
     * genre codes 1-20 since it only applies to bounded-range data.
     */
    public static void runEmpiricalComparison(int[] sizes) {
        Random random = new Random();

        System.out.printf("%8s | %15s | %15s | %18s%n",
                "Size", "Merge Sort (s)", "Quick Sort (s)", "Counting Sort* (s)");
        System.out.println("-".repeat(68));

        for (int n : sizes) {
            int[] randomData = new int[n];
            int[] genreData = new int[n];

            for (int i = 0; i < n; i++) {
                randomData[i] = random.nextInt(1_000_000_000);
                genreData[i] = 1 + random.nextInt(20);
            }

            long mergeTimeNs = timeMergeSort(randomData);
            long quickTimeNs = timeQuickSort(randomData);
            long countingTimeNs = timeCountingSort(genreData);

            System.out.printf("%8d | %15.6f | %15.6f | %18.6f%n",
                    n, mergeTimeNs / 1e9, quickTimeNs / 1e9, countingTimeNs / 1e9);
        }

        System.out.println();
        System.out.println("* Counting Sort is run on genre codes (range 1-20), not on the");
        System.out.println("  same random large-range data, since it is only valid for");
        System.out.println("  bounded/discrete category data.");
    }

    public static void main(String[] args) {
        System.out.println("Empirical comparison of Merge Sort, Quick Sort, and Counting Sort");
        System.out.println("=".repeat(68));
        runEmpiricalComparison(new int[]{100, 1000, 10000});
    }
}
