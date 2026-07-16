import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem 4: Employee Attendance Ranking
 *
 * Given employeeIds[] and attendance[] (parallel arrays) and an integer K,
 * return the Employee IDs of the top K employees with the highest
 * attendance percentages. Ties are broken by the smaller Employee ID
 * ranking higher.
 *
 * Example:
 * employeeIds = [101, 102, 103, 104, 105], attendance = [92, 85, 98, 92, 80], K = 3
 * Output: [103, 101, 104]
 */
public class EmployeeAttendanceRanking {

    // Simple pair class to keep an employee's ID and attendance together
    // while sorting, so we don't lose the ID-to-attendance mapping.
    private static class Employee {
        int id;
        int attendance;

        Employee(int id, int attendance) {
            this.id = id;
            this.attendance = attendance;
        }
    }

    public static int[] topKEmployees(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            employees[i] = new Employee(employeeIds[i], attendance[i]);
        }

        // Sort by attendance descending; break ties by employee ID ascending.
        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                if (a.attendance != b.attendance) {
                    return b.attendance - a.attendance; // higher attendance first
                }
                return a.id - b.id; // smaller ID ranks higher on a tie
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = employees[i].id;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;

        int[] topK = topKEmployees(employeeIds, attendance, k);

        System.out.print("Top " + k + " employee IDs: ");
        printArray(topK);
        // Expected output: [103, 101, 104]
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
