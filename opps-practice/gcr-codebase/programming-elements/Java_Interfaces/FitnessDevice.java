import java.util.ArrayList;
import java.util.List;

public class FitnessDevice implements Trackable, Reportable, Notifiable {
    private List<String> activities;
    private double totalCalories;
    private double totalDuration;
    
    public FitnessDevice() {
        this.activities = new ArrayList<>();
        this.totalCalories = 0;
        this.totalDuration = 0;
    }
    
    @Override
    public void logActivity(String activity, double duration, double calories) {
        activities.add(activity + " - Duration: " + duration + "hrs, Calories: " + calories);
        totalDuration += duration;
        totalCalories += calories;
        System.out.println("✓ Activity logged: " + activity);
    }
    
    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("\n========== FITNESS REPORT ==========\n");
        report.append("Total Activities: ").append(activities.size()).append("\n");
        report.append("Total Duration: ").append(totalDuration).append(" hours\n");
        report.append("Total Calories Burned: ").append(totalCalories).append("\n");
        report.append("\nActivities:\n");
        for (String activity : activities) {
            report.append("  • ").append(activity).append("\n");
        }
        report.append("===================================\n");
        return report.toString();
    }
    
    @Override
    public void sendAlert(String message) {
        System.out.println("🔔 ALERT: " + message);
    }
    
    @Override
    public void resetData() {
        Trackable.super.resetData();
        activities.clear();
        totalCalories = 0;
        totalDuration = 0;
        System.out.println("✓ All fitness data has been reset");
    }
}
