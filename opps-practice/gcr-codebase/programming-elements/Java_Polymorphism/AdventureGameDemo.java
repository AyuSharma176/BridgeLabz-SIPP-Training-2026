public class AdventureGameDemo {
    public static void main(String[] args) {
        System.out.println("========== ADVENTURE GAME - CHARACTER BATTLE ==========\n");
        
        GameCharacter[] characters = {
            new Warrior("Conan", 150, 30, "Broadsword"),
            new Mage("Gandalf", 100, 150, 40, "Fireball"),
            new Archer("Robin", 120, 30, 25),
            new Warrior("Aragorn", 140, 28, "Anduril"),
            new Mage("Merlin", 90, 200, 50, "Lightning"),
            new Archer("Legolas", 130, 40, 28)
        };
        
        System.out.println("Battle Participants:");
        for (GameCharacter character : characters) {
            System.out.println("  • " + character.getCharacterName() + " (HP: " + character.getHealthPoints() + ")");
        }
        
        System.out.println("\n========== BATTLE STARTS! ==========\n");
        
        startBattle(characters);
        
        System.out.println("\n========== BATTLE STATISTICS ==========\n");
        displayBattleStats(characters);
    }
    
    public static void startBattle(GameCharacter[] characters) {
        int rounds = 3;
        
        for (int round = 1; round <= rounds; round++) {
            System.out.println("--- ROUND " + round + " ---");
            
            for (GameCharacter character : characters) {
                if (character.isAlive()) {
                    character.performAttack();
                }
            }
            System.out.println();
        }
    }
    
    private static void displayBattleStats(GameCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;
        int aliveCount = 0;
        
        System.out.println("Final Statistics:");
        for (GameCharacter character : characters) {
            if (character instanceof Warrior) {
                warriorCount++;
            } else if (character instanceof Mage) {
                mageCount++;
            } else if (character instanceof Archer) {
                archerCount++;
            }
            
            if (character.isAlive()) {
                aliveCount++;
                System.out.println("  ✓ " + character.getCharacterName() + " - HP: " + character.getHealthPoints());
            } else {
                System.out.println("  ✗ " + character.getCharacterName() + " - DEFEATED");
            }
        }
        
        System.out.println("\nCharacter Type Breakdown:");
        System.out.println("  ⚔️  Warriors: " + warriorCount);
        System.out.println("  ✨ Mages: " + mageCount);
        System.out.println("  🏹 Archers: " + archerCount);
        System.out.println("  ❤️  Still Alive: " + aliveCount + "/" + characters.length);
        
        System.out.println("\n✓ Polymorphic Attack System: Each character uses its own attack method!");
    }
}
