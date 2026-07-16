public class Mage extends GameCharacter {
    private int manaPoints;
    private int spellDamage;
    private String spellName;
    
    public Mage(String characterName, int healthPoints, int manaPoints, int spellDamage, String spellName) {
        super(characterName, healthPoints);
        this.manaPoints = manaPoints;
        this.spellDamage = spellDamage;
        this.spellName = spellName;
    }
    
    @Override
    public void performAttack() {
        if (manaPoints >= 20) {
            int damage = spellDamage + (int)(Math.random() * 30);
            this.damageDealt = damage;
            manaPoints -= 20;
            System.out.println("✨ " + characterName + " (Mage) casts " + spellName);
            System.out.println("   Damage dealt: " + damage + " HP | Mana remaining: " + manaPoints);
        } else {
            System.out.println("✨ " + characterName + " (Mage) lacks mana to cast spell!");
            this.damageDealt = 0;
        }
    }
    
    public int getManaPoints() {
        return manaPoints;
    }
    
    public int getSpellDamage() {
        return spellDamage;
    }
    
    public String getSpellName() {
        return spellName;
    }
}
