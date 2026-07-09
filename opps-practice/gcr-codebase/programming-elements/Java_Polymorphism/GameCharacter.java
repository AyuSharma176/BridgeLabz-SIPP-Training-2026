public abstract class GameCharacter {
    protected String characterName;
    protected int healthPoints;
    protected int damageDealt;
    
    public GameCharacter(String characterName, int healthPoints) {
        this.characterName = characterName;
        this.healthPoints = healthPoints;
        this.damageDealt = 0;
    }
    
    public abstract void performAttack();
    
    public String getCharacterName() {
        return characterName;
    }
    
    public int getHealthPoints() {
        return healthPoints;
    }
    
    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }
    
    public boolean isAlive() {
        return healthPoints > 0;
    }
}
