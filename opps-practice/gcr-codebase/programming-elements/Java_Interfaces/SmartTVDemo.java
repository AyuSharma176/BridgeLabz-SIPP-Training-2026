public class SmartTVDemo {
    public static void main(String[] args) {
        SmartTV tv = new SmartTV();
        
        System.out.println("========== SMART TV DEMO ==========\n");
        
        // Show subscription details (resolves default method conflict)
        tv.showSubscriptionDetails();
        
        // Display all available content
        tv.displayAllContent();
        
        // Stream movies (using StreamingService)
        System.out.println("--- Testing StreamingService ---");
        tv.streamMovie("Inception");
        tv.streamMovie("Avatar");
        tv.streamMovie("NotAvailable");
        
        // Play games (using GamingService)
        System.out.println("\n--- Testing GamingService ---");
        tv.playGame("Elden Ring");
        tv.playGame("Fortnite");
        tv.playGame("NonExistentGame");
        
        System.out.println("\n--- Interface Implementation ---");
        System.out.println("SmartTV implements: StreamingService, GamingService");
        System.out.println("Default Method Conflict: RESOLVED by overriding showSubscriptionDetails()");
    }
}
