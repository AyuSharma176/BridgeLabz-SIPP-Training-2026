/**
 * Problem 1: Bubble Sort - Sort Student Marks
 *
 * A school maintains student marks in an array. Implement Bubble Sort
 * to sort the student marks in ascending order.
 */
public class BubbleSortStudentMarks {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // After each pass, the largest element bubbles up to the end,
            // so we don't need to check the last i elements again.
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in this pass, the array is sorted.
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {88, 45, 67, 90, 23, 78, 55};

        System.out.print("Original marks: ");
        printArray(marks);

        bubbleSort(marks);

        System.out.print("Sorted marks:   ");
        printArray(marks);
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
