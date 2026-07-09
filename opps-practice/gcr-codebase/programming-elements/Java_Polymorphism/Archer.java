public class Archer extends GameCharacter {
    private int arrows;
    private int arrowDamage;
    
    public Archer(String characterName, int healthPoints, int arrows, int arrowDamage) {
        super(characterName, healthPoints);
        this.arrows = arrows;
        this.arrowDamage = arrowDamage;
    }
    
    @Override
    public void performAttack() {
        if (arrows > 0) {
            int damage = arrowDamage + (int)(Math.random() * 15);
            this.damageDealt = damage;
            arrows--;
            System.out.println("🏹 " + characterName + " (Archer) shoots an arrow");
            System.out.println("   Damage dealt: " + damage + " HP | Arrows remaining: " + arrows);
        } else {
            System.out.println("🏹 " + characterName + " (Archer) has no arrows left!");
            this.damageDealt = 0;
        }
    }
    
    public int getArrows() {
        return arrows;
    }
    
    public int getArrowDamage() {
        return arrowDamage;
    }
}
