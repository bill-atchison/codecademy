import java.util.Random;

public class Entity {
    private int hitPoints;
    private int damage;
    private String weapon;
    private String name;
    private int maxHitPoints;

    public Entity(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.maxHitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public void takeDamage() {
        Random rand = new Random();
        int damage = rand.nextInt(this.getDamage()) + 1;
        int hitPointsRemaining = this.getHitPoints() - damage;
        /*
        hitPointsRemaining = hitPointsRemaining < 0 ? 0 : hitPointsRemaining;
        this.setHitPoints(hitPointsRemaining);
        */
        this.setHitPoints(Math.max(hitPointsRemaining, 0));
    }
}
