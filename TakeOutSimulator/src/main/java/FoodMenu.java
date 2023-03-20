import java.util.ArrayList;
import java.util.List;

// Create FoodMenu class here
public class FoodMenu {
    private List<Food> menu = new ArrayList<>();

    FoodMenu() {
        menu.add(new Food("Tacos", "Yummy Steak Taco", 10));
        menu.add(new Food("Ice Cream", "Peanut Butter Cone", 5));
        menu.add(new Food("Coke", "16 oz Coke", 3));
    }

    @Override
    public String toString() {
        //return super.toString();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < menu.size(); i++) {
            sb.append(i + 1).append(". ").append(menu.get(i).toString());
        }

        return sb.toString();
    }

    public Food getFood(int index) {
        if(index > menu.size()) {
            return null;
        }

        return menu.get(index - 1);
    }

    public Food getLowestCostFood() {
        int index = 0;
        int lowestPrice;

        if(menu.isEmpty()) {
            return null;
        }

        lowestPrice = menu.get(0).getPrice();

        for(int i = 1; i < menu.size(); i++) {
            if(menu.get(i).getPrice() < lowestPrice) {
                index = i;
                lowestPrice = menu.get(i).getPrice();
            }
        }

        return getFood(index + 1);
    }
}
