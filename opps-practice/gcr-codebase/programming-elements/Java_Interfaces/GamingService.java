public interface GamingService {
    void playGame(String gameName);
    
    default void showSubscriptionDetails() {
        System.out.println("🎮 Gaming Service Subscription: Unlimited Games");
    }
}
