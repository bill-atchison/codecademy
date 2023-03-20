import java.util.HashMap;
import java.util.Map;

// Create ShoppingBag class here
public class ShoppingBag <T extends PricedItem<Integer>> {
    private Map<T, Integer> shoppingBag;

    ShoppingBag() {
        shoppingBag = new HashMap<>();
    }

    public void addItem(T item) {
        boolean foundItem = false;

        try {
            if (shoppingBag.isEmpty()) {
                shoppingBag.put(item, 1);
            } else {
                for (Map.Entry<T, Integer> element : shoppingBag.entrySet()) {
                    if (element.getKey().getPrice().equals(item.getPrice())) {
                        Integer count = element.getValue();
                        count++;
                        element.setValue(count);
                        foundItem = true;
                        break;
                    }
                }

                if(!foundItem) {
                    shoppingBag.put(item, 1);
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("addItem Exception: " + e);
            System.out.println(e.getStackTrace());
        }
    }

    public Integer getTotalPrice() {
        Integer totalPrice = 0;

        for(T item : shoppingBag.keySet()) {
            //System.out.println("key: " + item + "  value: " + shoppingBag.get(item));
            totalPrice += (item.getPrice() * shoppingBag.get(item));
        }

        return totalPrice;
    }


}
