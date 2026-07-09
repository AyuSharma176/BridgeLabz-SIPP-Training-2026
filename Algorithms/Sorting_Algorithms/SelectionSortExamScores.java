/**
 * Problem 3: Selection Sort - Sort Exam Scores
 *
 * A university needs to sort students' exam scores in ascending order.
 * Implement Selection Sort to achieve this.
 */
public class SelectionSortExamScores {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the remaining unsorted part.
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element.
            if (minIndex != i) {
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] scores = {72, 58, 91, 64, 85, 47};

        System.out.print("Original scores: ");
        printArray(scores);

        selectionSort(scores);

        System.out.print("Sorted scores:   ");
        printArray(scores);
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
