public interface Trackable {
    void logActivity(String activity, double duration, double calories);
    
    // Default method - Java's way to add behavior to interfaces
    default void resetData() {
        System.out.println("Resetting all tracked data to default values...");
    }
}
