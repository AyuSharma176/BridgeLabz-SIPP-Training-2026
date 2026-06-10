interface Trackable {

    void logActivity();

    // Default method
    default void resetData() {
        System.out.println("Fitness data has been reset.");
    }
}
