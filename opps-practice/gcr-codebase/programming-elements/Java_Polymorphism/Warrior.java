public class Warrior extends GameCharacter {
    private int weaponDamage;
    private String weaponName;
    
    public Warrior(String characterName, int healthPoints, int weaponDamage, String weaponName) {
        super(characterName, healthPoints);
        this.weaponDamage = weaponDamage;
        this.weaponName = weaponName;
    }
    
    @Override
    public void performAttack() {
        int damage = weaponDamage + (int)(Math.random() * 20);
        this.damageDealt = damage;
        System.out.println("⚔️  " + characterName + " (Warrior) attacks with " + weaponName);
        System.out.println("   Damage dealt: " + damage + " HP");
    }
    
    public int getWeaponDamage() {
        return weaponDamage;
    }
    
    public String getWeaponName() {
        return weaponName;
    }
}
