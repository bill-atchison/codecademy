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

    }
}
