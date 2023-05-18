// Create Food class here
public class Food implements PricedItem<Integer> {
    private String name;
    private int price;
    private String description;

    Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        //System.out.printf("Enjoy %s: %s\tCost: %d\n", this.name, this.description, this.price);
        return "Enjoy " + this.name + ": " + this.description + "\tCost: " + this.price +"\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
