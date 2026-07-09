public class SmartTV implements StreamingService, GamingService {
    private String[] movies;
    private String[] games;
    
    public SmartTV() {
        this.movies = new String[]{"The Matrix", "Inception", "Interstellar", "Avatar", "Dune"};
        this.games = new String[]{"Elden Ring", "Cyberpunk 2077", "Fortnite", "Call of Duty", "The Last of Us"};
    }
    
    @Override
    public void streamMovie(String movieName) {
        if (isMovieAvailable(movieName)) {
            System.out.println(" Now streaming: " + movieName);
        } else {
            System.out.println("Movie not available: " + movieName);
        }
    }
    
    @Override
    public void playGame(String gameName) {
        if (isGameAvailable(gameName)) {
            System.out.println("Now playing: " + gameName);
        } else {
            System.out.println("Game not available: " + gameName);
        }
    }
    
    // Resolving default method conflict - choosing to override with combined implementation
    @Override
    public void showSubscriptionDetails() {
        System.out.println("\n========== SMART TV SUBSCRIPTION DETAILS ==========");
        System.out.println("Streaming Service: Premium Movies Available");
        System.out.println("Gaming Service: Unlimited Games Available");
        System.out.println("All services combined in one subscription!");
        System.out.println("==================================================\n");
    }
    
    private boolean isMovieAvailable(String movieName) {
        for (String movie : movies) {
            if (movie.equalsIgnoreCase(movieName)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isGameAvailable(String gameName) {
        for (String game : games) {
            if (game.equalsIgnoreCase(gameName)) {
                return true;
            }
        }
        return false;
    }
    
    public void displayAllContent() {
        System.out.println("\n========== ALL AVAILABLE CONTENT ==========");
        
        System.out.println("\n🎬 Movies Available:");
        for (String movie : movies) {
            System.out.println("   • " + movie);
        }
        
        System.out.println("\n🎮 Games Available:");
        for (String game : games) {
            System.out.println("   • " + game);
        }
        
        System.out.println("\n==========================================\n");
    }
}
