public class FitnessDevice implements Trackable, Reportable, Notifiable {

    // Member variables
    String userName;
    int stepsWalked;
    double caloriesBurned;

    // Constructor
    public FitnessDevice(String userName, int stepsWalked, double caloriesBurned) {
        this.userName = userName;
        this.stepsWalked = stepsWalked;
        this.caloriesBurned = caloriesBurned;
    }

    // Implement Trackable method
    public void logActivity() {
        System.out.println("Activity Logged Successfully.");
    }

    // Implement Reportable method
    public void generateReport() {
        System.out.println("\n----- Fitness Report -----");
        System.out.println("User Name       : " + userName);
        System.out.println("Steps Walked    : " + stepsWalked);
        System.out.println("Calories Burned : " + caloriesBurned);
    }

    // Implement Notifiable method
    public void sendAlert() {
        System.out.println("Alert: Daily fitness goal achieved!");
    }
}
