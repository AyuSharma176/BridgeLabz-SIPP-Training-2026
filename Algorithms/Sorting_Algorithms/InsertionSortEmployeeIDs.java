/**
 * Problem 2: Insertion Sort - Sort Employee IDs
 *
 * A company stores employee IDs in an unsorted array. Implement Insertion
 * Sort to sort the employee IDs in ascending order.
 */
public class InsertionSortEmployeeIDs {

    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;

        // First element is trivially "sorted". Grow the sorted part
        // one element at a time.
        for (int i = 1; i < n; i++) {
            int current = employeeIds[i];
            int j = i - 1;

            // Shift elements of the sorted part that are greater than
            // 'current' one position ahead to make room for it.
            while (j >= 0 && employeeIds[j] > current) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }

            employeeIds[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] employeeIds = {1042, 1005, 1099, 1010, 1077};

        System.out.print("Original employee IDs: ");
        printArray(employeeIds);

        insertionSort(employeeIds);

        System.out.print("Sorted employee IDs:   ");
        printArray(employeeIds);
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}
