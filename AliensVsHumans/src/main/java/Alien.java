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
    }

    public void regenerate() {

    }
}
