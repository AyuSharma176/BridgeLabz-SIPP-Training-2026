public class FitnessTrackerDemo {
    public static void main(String[] args) {

        // Create FitnessDevice object
        FitnessDevice fitnessDevice =new FitnessDevice("Ravi", 12000, 550.75);

        // Call interface methods
        fitnessDevice.logActivity();
        fitnessDevice.generateReport();
        fitnessDevice.sendAlert();

        // Call default method from Trackable interface
        fitnessDevice.resetData();
    }
}