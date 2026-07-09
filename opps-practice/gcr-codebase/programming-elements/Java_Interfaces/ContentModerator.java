public class ContentModerator implements TextModeration, SpamDetection {
    private String[] posts;
    
    public ContentModerator(String[] posts) {
        this.posts = posts;
    }
    
    @Override
    public boolean isOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }
    
    @Override
    public boolean isSpam(String post) {
        String lowerPost = post.toLowerCase();
        
        // Check for spam indicators
        if (lowerPost.contains("click here") || 
            lowerPost.contains("buy now") || 
            lowerPost.contains("follow link") ||
            lowerPost.contains("limited time") ||
            lowerPost.contains("act now")) {
            return true;
        }
        
        // Check for excessive special characters
        int specialCharCount = 0;
        for (char c : post.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                specialCharCount++;
            }
        }
        
        return specialCharCount > post.length() / 3;
    }
    
    // Override to resolve default method conflict
    @Override
    public void displayModerationPolicy() {
        System.out.println("\n📋 ========== CONTENT MODERATION POLICIES ==========");
        System.out.println("🔒 Text Moderation: Checking for offensive language and hate speech");
        System.out.println("⚠️  Spam Detection: Checking for spam and promotional content");
        System.out.println("===================================================\n");
    }
    
    public void moderateAllPosts() {
        displayModerationPolicy();
        
        System.out.println("Analyzing " + posts.length + " posts...\n");
        
        int validCount = 0;
        int spamCount = 0;
        int offensiveCount = 0;
        
        for (int i = 0; i < posts.length; i++) {
            String post = posts[i];
            boolean spam = isSpam(post);
            boolean offensive = isOffensive(post);
            
            String status;
            if (offensive) {
                status = "❌ OFFENSIVE";
                offensiveCount++;
            } else if (spam) {
                status = "⚠️  SPAM";
                spamCount++;
            } else {
                status = "✓ VALID";
                validCount++;
            }
            
            System.out.println("[" + (i + 1) + "] " + status + ": \"" + post + "\"");
        }
        
        printSummary(validCount, spamCount, offensiveCount);
    }
    
    private void printSummary(int valid, int spam, int offensive) {
        System.out.println("\n========== MODERATION SUMMARY ==========");
        System.out.println("✓ Valid Posts: " + valid);
        System.out.println("⚠️  Spam Posts: " + spam);
        System.out.println("❌ Offensive Posts: " + offensive);
        System.out.println("Total Posts: " + posts.length);
        System.out.println("========================================\n");
    }
}
