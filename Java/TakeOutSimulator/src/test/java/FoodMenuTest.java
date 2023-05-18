import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FoodMenuTest {
    FoodMenu menu;

    @Before
    public void setUp() throws Exception {
        menu = new FoodMenu();
    }


    @Test
    public void testToString() {
        System.out.println(menu);
    }

    @Test
    public void getFood() {
        Food food = menu.getFood(1);
        System.out.println(food);
        assertEquals(food.getName(), "Tacos");
    }

    @Test
    public void getLowestCostFood() {
        int lowestPrice = menu.getLowestCostFood().getPrice();
        assertTrue("getLowestPrice Error", lowestPrice == 3);
    }
}