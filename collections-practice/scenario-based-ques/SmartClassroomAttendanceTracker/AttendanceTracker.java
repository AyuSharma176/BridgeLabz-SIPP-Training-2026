import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AttendanceTracker manages student attendance across multiple subjects.
 * Uses a HashMap<String, ArrayList<String>> where:
 *   Key   -> Subject Name
 *   Value -> List of students marked present in that subject
 *
 * Duplicate attendance entries for the same student in the same subject
 * are automatically prevented.
 */
public class AttendanceTracker {

    private final HashMap<String, ArrayList<String>> attendanceMap;

    public AttendanceTracker() {
        this.attendanceMap = new HashMap<>();
    }

    /**
     * Marks a student present for a given subject. If the subject does not
     * yet exist in the map, it is created. If the student is already marked
     * present for that subject, the duplicate entry is rejected.
     *
     * @param subject     the subject name
     * @param studentName the student's name
     * @return true if attendance was marked successfully, false if it was
     *         a duplicate or invalid entry
     */
    public boolean markAttendance(String subject, String studentName) {
        if (subject == null || subject.trim().isEmpty()
                || studentName == null || studentName.trim().isEmpty()) {
            System.out.println("Failed: Subject and student name cannot be empty.");
            return false;
        }

        String subjectKey = subject.trim();
        String student = studentName.trim();

        // Create a new list for this subject if it doesn't already exist
        attendanceMap.putIfAbsent(subjectKey, new ArrayList<>());

        ArrayList<String> studentsPresent = attendanceMap.get(subjectKey);

        // Prevent duplicate attendance for the same student in this subject
        if (studentsPresent.contains(student)) {
            System.out.println("Rejected: \"" + student + "\" is already marked present for \""
                    + subjectKey + "\".");
            return false;
        }

        studentsPresent.add(student);
        System.out.println("Success: \"" + student + "\" marked present for \"" + subjectKey + "\".");
        return true;
    }

    /**
     * Displays the attendance list for every subject recorded so far.
     */
    public void displayAllAttendance() {
        System.out.println("\n----- Attendance Records -----");
        if (attendanceMap.isEmpty()) {
            System.out.println("No attendance has been recorded yet.");
            return;
        }

        for (Map.Entry<String, ArrayList<String>> entry : attendanceMap.entrySet()) {
            System.out.println("\nSubject: " + entry.getKey());
            List<String> students = entry.getValue();

            if (students.isEmpty()) {
                System.out.println("  No students present.");
            } else {
                int count = 1;
                for (String student : students) {
                    System.out.println("  " + count + ". " + student);
                    count++;
                }
            }
            System.out.println("  Total present: " + students.size());
        }
        System.out.println("\n-------------------------------");
    }

    /**
     * Displays the attendance list for a single subject.
     *
     * @param subject the subject name to look up
     */
    public void displayAttendanceForSubject(String subject) {
        String subjectKey = subject.trim();
        ArrayList<String> students = attendanceMap.get(subjectKey);

        if (students == null) {
            System.out.println("No records found for subject \"" + subjectKey + "\".");
            return;
        }

        System.out.println("\nSubject: " + subjectKey);
        if (students.isEmpty()) {
            System.out.println("  No students present.");
        } else {
            int count = 1;
            for (String student : students) {
                System.out.println("  " + count + ". " + student);
                count++;
            }
        }
        System.out.println("  Total present: " + students.size());
    }

    /**
     * @return the total number of students present across all subjects
     *         (counts a student once per subject they attended)
     */
    public int getTotalAttendanceAcrossSubjects() {
        int total = 0;
        for (ArrayList<String> students : attendanceMap.values()) {
            total += students.size();
        }
        return total;
    }

    /**
     * @return the underlying attendance map (useful for tests/extensions)
     */
    public HashMap<String, ArrayList<String>> getAttendanceMap() {
        return attendanceMap;
    }
}
