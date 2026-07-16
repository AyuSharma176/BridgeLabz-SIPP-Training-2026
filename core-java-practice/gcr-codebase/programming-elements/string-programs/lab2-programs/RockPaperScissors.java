// Program 9: Rock-Paper-Scissors game between user and computer with stats
import java.util.Scanner;

class RockPaperScissors {

    // Method to get the computer's choice using Math.random()
    // Returns: "Rock", "Paper", or "Scissors"
    public static String getComputerChoice() {
        int randomNumber = (int) (Math.random() * 3); // 0, 1, or 2
        if (randomNumber == 0) {
            return "Rock";
        } else if (randomNumber == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    // Method to find the winner between user and computer
    // Returns: "Player", "Computer", or "Draw"
    public static String findWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "Draw";
        }
        // Rock crushes Scissors
        if (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) {
            return "Player";
        }
        // Paper covers Rock
        if (playerChoice.equals("Paper") && computerChoice.equals("Rock")) {
            return "Player";
        }
        // Scissors cuts Paper
        if (playerChoice.equals("Scissors") && computerChoice.equals("Paper")) {
            return "Player";
        }
        return "Computer";
    }

    // Method to calculate win percentage for player and computer
    // Returns 2D String array: [[playerWins, computerWins, draws, playerPercent, computerPercent]]
    public static String[][] calculateStats(int playerWins, int computerWins, int draws, int totalGames) {
        double playerPercent = Math.round(((double) playerWins / totalGames) * 10000.0) / 100.0;
        double computerPercent = Math.round(((double) computerWins / totalGames) * 10000.0) / 100.0;
        double drawPercent = Math.round(((double) draws / totalGames) * 10000.0) / 100.0;

        String[][] stats = new String[3][2];
        stats[0][0] = "Player";
        stats[0][1] = playerWins + " wins (" + playerPercent + "%)";
        stats[1][0] = "Computer";
        stats[1][1] = computerWins + " wins (" + computerPercent + "%)";
        stats[2][0] = "Draws";
        stats[2][1] = draws + " draws (" + drawPercent + "%)";

        return stats;
    }

    // Method to display each game result and final stats
    public static void displayResults(String[][] gameResults, String[][] stats, int totalGames) {
        // Display each game result
        System.out.println("\n--- Game Results ---");
        System.out.printf("%-6s %-12s %-12s %-10s%n", "Game", "Player", "Computer", "Winner");
        System.out.println("------------------------------------------");
        for (int i = 0; i < totalGames; i++) {
            System.out.printf("%-6d %-12s %-12s %-10s%n",
                    (i + 1), gameResults[i][0], gameResults[i][1], gameResults[i][2]);
        }

        // Display summary stats
        System.out.println("\n--- Final Statistics ---");
        System.out.printf("%-12s %-30s%n", "Category", "Result");
        System.out.println("------------------------------------------");
        for (String[] stat : stats) {
            System.out.printf("%-12s %-30s%n", stat[0], stat[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for number of games
        System.out.print("Enter number of games to play: ");
        int totalGames = sc.nextInt();

        String[] choices = {"Rock", "Paper", "Scissors"};
        String[][] gameResults = new String[totalGames][3]; // [playerChoice, computerChoice, winner]

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        System.out.println("\nChoices: 1 = Rock | 2 = Paper | 3 = Scissors");

        for (int i = 0; i < totalGames; i++) {
            System.out.print("Game " + (i + 1) + " - Enter your choice (1/2/3): ");
            int choiceNumber = sc.nextInt();

            // Validate input
            while (choiceNumber < 1 || choiceNumber > 3) {
                System.out.print("Invalid choice! Enter 1, 2, or 3: ");
                choiceNumber = sc.nextInt();
            }

            String playerChoice = choices[choiceNumber - 1];
            String computerChoice = getComputerChoice();
            String winner = findWinner(playerChoice, computerChoice);

            gameResults[i][0] = playerChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }
        }

        // Calculate stats
        String[][] stats = calculateStats(playerWins, computerWins, draws, totalGames);

        // Display all results
        displayResults(gameResults, stats, totalGames);

        sc.close();
    }
}
