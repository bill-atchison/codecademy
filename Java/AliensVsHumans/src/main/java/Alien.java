import java.util.Random;

public class Alien extends Entity {
    private boolean mutated;

    public Alien(String name, int hitPoints) {
        super(name, hitPoints);
        this.mutated = false;
    }

    public boolean isMutated() {
        return mutated;
    }

    public void setMutated(boolean mutated) {
        this.mutated = mutated;
        if(mutated) {
            int hitPoints = this.getHitPoints() + 50;
            int maxHitPoints = this.getMaxHitPoints() + 50;
            this.setHitPoints(hitPoints);
            this.setMaxHitPoints(maxHitPoints);
        }
    }

    public void regenerate() {
        Random rand = new Random();

        int healingPoints;

        if(this.isMutated()) {
            healingPoints = rand.nextInt(20);
        }
        else {
            healingPoints = rand.nextInt(10);
        }

        int newHitPoints = this.getHitPoints() + healingPoints;
        /*
        newHitPoints = (newHitPoints > this.getMaxHitPoints()) ? this.getMaxHitPoints() : newHitPoints;
        this.setHitPoints(newHitPoints);
        */
        this.setHitPoints(Math.min(newHitPoints, this.getMaxHitPoints()));
    }

}
