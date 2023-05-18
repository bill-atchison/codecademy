import java.util.Random;

public class Human extends Entity {
    private int armorPoints;
    private String armorType;

    public Human(String name, int hitPoints) {
        super(name, hitPoints);
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public void eatFood() {
        Random rand = new Random();

        int healingPoints = rand.nextInt(20);
        int newHitPoints = this.getHitPoints() + healingPoints;
        /*
        newHitPoints = (newHitPoints > this.getMaxHitPoints()) ? this.getMaxHitPoints() : newHitPoints;
        this.setHitPoints(newHitPoints);
         */
        this.setHitPoints(Math.min(newHitPoints, this.getMaxHitPoints()));
    }

    public void equipWeapon(String weapon) {
        int damage;
        switch(weapon) {
            case "Mace" : damage = 5;
            break;
            case "Gun"  : damage = 10;
            break;
            case "Laser" : damage = 20;
            break;
            default : damage = 2;
        }

        this.setDamage(damage);
        this.setWeapon(weapon);
    }

    public void equipArmor(String armorType) {
        int armorPoints;
        switch(armorType) {
            case "Cloth" : armorPoints = 5;
            break;
            case "Leather" : armorPoints = 10;
            break;
            case "Body Armor" : armorPoints =20;
            break;
            default : armorPoints = 0;
        }

        this.setArmorPoints(armorPoints);
        this.setArmorType(armorType);
    }
    @Override
    public void takeDamage() {
        Random rand = new Random();
        int damage = rand.nextInt(this.getDamage()) + 1;

        int armorDamage = rand.nextInt(damage) + 1;
        /*
        armorDamage = armorDamage > this.getArmorPoints() ? this.getArmorPoints() : armorDamage;
        int armorPointsRemaining = this.getArmorPoints() - armorDamage;
         */
        int armorPointsRemaining = this.getArmorPoints() - Math.min(armorDamage, this.getArmorPoints());
        this.setArmorPoints(armorPointsRemaining);

        int hitPointsRemaining = this.getHitPoints() - (damage - armorDamage);
        /*
        hitPointsRemaining = hitPointsRemaining < 0 ? 0 : hitPointsRemaining;
        this.setHitPoints(hitPointsRemaining);
         */
        this.setHitPoints(Math.max(hitPointsRemaining, 0));
    }
}
