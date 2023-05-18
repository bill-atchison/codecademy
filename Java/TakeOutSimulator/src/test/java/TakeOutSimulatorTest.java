import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class TakeOutSimulatorTest {
    private TakeOutSimulator simulator;
    private Customer customer = new Customer();
    private FoodMenu menu = new FoodMenu();
    private Scanner input = new Scanner(System.in);

    @Before
    public void setUp() throws Exception {
        simulator = new TakeOutSimulator(customer, menu, input);
        customer.setMoney(20);
        customer.setName("Mike");

    }

    @Test
    public void shouldSimulate() {
        assertTrue("", !simulator.shouldSimulate());
    }

    @Test
    public void getMenuSelection() {
        assertTrue("", simulator.getMenuSelection().getName().equals("Tacos"));
    }

    @Test
    public void isStillOrderingFood() {
        assertTrue("", !simulator.isStillOrderingFood());
    }

    @Test
    public void checkoutCustomer() {
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        shoppingBag.addItem(new Food("Tacos", "Yummy Steak Tacos", 10));
        shoppingBag.addItem(new Food("Ice Cream", "Sweet Ice Cream", 5));

        simulator.checkoutCustomer(shoppingBag);
        assertEquals(customer.getMoney(), 5);
    }

    @Test
    public void takeOutPrompt() {
        simulator.takeOutPrompt();
    }

    @Test
    public void startTakeOutSimulator() {
        simulator.startTakeOutSimulator();
    }
}