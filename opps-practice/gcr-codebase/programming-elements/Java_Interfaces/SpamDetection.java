public interface SpamDetection {
    boolean isSpam(String post);
    
    default void displayModerationPolicy() {
        System.out.println("⚠️  Spam Detection Policy: Checking for spam, phishing, and promotional content.");
    }
}
