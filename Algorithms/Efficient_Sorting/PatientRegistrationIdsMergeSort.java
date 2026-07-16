import java.util.Scanner;

/**
 * Problem 3: Merge Sort - Patient Registration IDs
 *
 * Sorts patient registration IDs in ascending order using Merge Sort
 * (no built-in sort functions used).
 *
 * Input Format:
 *   Line 1: integer N
 *   Line 2: N integers representing patient IDs
 *
 * Output Format:
 *   Sorted patient IDs, space-separated
 */
public class PatientRegistrationIdsMergeSort {

    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());
        int[] patientIds = new int[n];

        String[] tokens = scanner.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            patientIds[i] = Integer.parseInt(tokens[i]);
        }

        int[] temp = new int[n];
        mergeSort(patientIds, temp, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(patientIds[i]);
            if (i != n - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
        scanner.close();
    }
}
