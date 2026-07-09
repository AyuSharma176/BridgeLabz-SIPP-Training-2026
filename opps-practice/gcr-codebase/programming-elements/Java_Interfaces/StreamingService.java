public interface StreamingService {
    void streamMovie(String movieName);
    
    default void showSubscriptionDetails() {
        System.out.println("📺 Streaming Service Subscription: Premium Movies");
    }
}
