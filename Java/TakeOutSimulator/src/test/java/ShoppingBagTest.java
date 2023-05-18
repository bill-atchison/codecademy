import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingBagTest implements PricedItem<Integer> {
    Integer price;

    @Before
    public void setUp() throws Exception {
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Test
    public void addItem() {
        ShoppingBag<PricedItem<Integer>> shoppingBag = new ShoppingBag<>();
        shoppingBag.addItem(new Food("taco", "steak taco", 10));
        shoppingBag.addItem(new Food("ice cream", "peanut butter ice cream", 5));
        shoppingBag.addItem(new Food("taco", "steak taco", 10));
    }

    @Test
    public void getTotalPrice() {
        ShoppingBag<PricedItem<Integer>> shoppingBag = new ShoppingBag<>();
        shoppingBag.addItem(new Food("taco", "steak taco", 10));
        shoppingBag.addItem(new Food("ice cream", "peanut butter ice cream", 5));
        shoppingBag.addItem(new Food("taco", "steak taco", 10));
        System.out.println(shoppingBag.getTotalPrice());
        assertTrue("getTotalPrice is Incorrect", 25 == shoppingBag.getTotalPrice());
    }
}