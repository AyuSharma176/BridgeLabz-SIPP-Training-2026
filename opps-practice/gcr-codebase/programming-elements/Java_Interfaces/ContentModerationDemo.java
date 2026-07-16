public class ContentModerationDemo {
    public static void main(String[] args) {
        String[] posts = {
            "I love this movie, best one ever!",
            "click here to buy now!!! limited time offer!!!",
            "This content is so offensive and abusive",
            "Just finished my morning jog, feeling great!",
            "Follow link for FREE MONEY!!! $$$",
            "I hate this platform, it's the worst",
            "Anyone want to grab coffee later?",
            "BUY NOW!!! ACT NOW!!! !!!!!!!!",
            "Great tutorial, learned something new today",
            "This is inappropriate and vulgar content here"
        };
        
        System.out.println("========== AI-BASED CONTENT MODERATION PLATFORM ==========\n");
        
        ContentModerator moderator = new ContentModerator(posts);
        
        // Moderate all posts
        moderator.moderateAllPosts();
        
        System.out.println("--- Additional Information ---");
        System.out.println("• TextModeration detects offensive language using containsRestrictedWords()");
        System.out.println("• SpamDetection identifies spam patterns and promotional content");
        System.out.println("• Default method conflict resolved by overriding displayModerationPolicy()");
    }
}
