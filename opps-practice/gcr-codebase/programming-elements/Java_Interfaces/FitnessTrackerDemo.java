public class FitnessTrackerDemo {
    public static void main(String[] args) {
        System.out.println("========== FITNESS TRACKER DEMO ==========\n");
        
        FitnessDevice device = new FitnessDevice();
        
        // Using Trackable interface
        System.out.println("--- Using Trackable Interface ---");
        device.logActivity("Running", 1.5, 300);
        device.logActivity("Swimming", 1.0, 400);
        device.logActivity("Cycling", 2.0, 350);
        
        // Using Notifiable interface
        System.out.println("\n--- Using Notifiable Interface ---");
        if (device instanceof Notifiable) {
            device.sendAlert("You've burned more than 1000 calories this week!");
        }
        
        // Using Reportable interface
        System.out.println("\n--- Using Reportable Interface ---");
        if (device instanceof Reportable) {
            System.out.println(device.generateReport());
        }
        
        // Using Trackable's default method
        System.out.println("--- Using Trackable's Default Method ---");
        device.resetData();
        
        System.out.println("\n--- Demonstrating Multiple Interface Implementation ---");
        System.out.println("FitnessDevice implements: Trackable, Reportable, Notifiable");
        System.out.println("This shows that Java classes CAN implement multiple interfaces");
        System.out.println("(while classes can only extend one other class)");
    }
}
