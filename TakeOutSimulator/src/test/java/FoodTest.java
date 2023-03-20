import static org.junit.Assert.*;

public class FoodTest {
    Food food;

    @org.junit.Before
    public void setUp() throws Exception {
        food = new Food("taco", "steak taco", 10);
    }

    @org.junit.Test
    public void getPrice() {
        System.out.println(food.getPrice());
    }

    @org.junit.Test
    public void setPrice() {
        food.setPrice(5);
        System.out.println(food.getPrice());
    }

    @org.junit.Test
    public void testToString() {
        System.out.println(food);
    }
}