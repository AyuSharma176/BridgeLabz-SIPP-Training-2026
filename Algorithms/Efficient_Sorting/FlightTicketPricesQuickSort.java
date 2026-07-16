import java.util.Scanner;

/**
 * Problem 4: Quick Sort - Flight Ticket Prices
 *
 * Sorts ticket prices in ascending order using Quick Sort
 * (Lomuto partition scheme, no built-in sort functions used).
 *
 * Input Format:
 *   Line 1: integer N
 *   Line 2: N integers representing ticket prices
 *
 * Output Format:
 *   Sorted ticket prices in ascending order, space-separated
 */
public class FlightTicketPricesQuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = lomutoPartition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());
        int[] prices = new int[n];

        String[] tokens = scanner.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(tokens[i]);
        }

        quickSort(prices, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(prices[i]);
            if (i != n - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
        scanner.close();
    }
}
