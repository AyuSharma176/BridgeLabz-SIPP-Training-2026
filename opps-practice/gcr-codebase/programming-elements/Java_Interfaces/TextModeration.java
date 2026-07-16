public interface TextModeration {
    boolean isOffensive(String post);
    
    default void displayModerationPolicy() {
        System.out.println("🔒 Text Moderation Policy: Checking for offensive language, hate speech, and abusive content.");
    }
    
    static boolean containsRestrictedWords(String post) {
        String[] restrictedWords = {"hate", "abuse", "offensive", "vulgar", "inappropriate"};
        String lowerPost = post.toLowerCase();
        
        for (String word : restrictedWords) {
            if (lowerPost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
