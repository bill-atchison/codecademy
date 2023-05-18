import org.jetbrains.annotations.NotNull;

import java.util.InputMismatchException;
import java.util.Scanner;

// Create TakeOutSimulator class here
public class TakeOutSimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    TakeOutSimulator(Customer customer, FoodMenu menu, Scanner input) {
        this.customer = customer;
        this.menu = menu;
        this.input = input;
    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever intUserInputRetriever ) {
        int num = 0;

        while(true) {
             try {
                System.out.println(userInputPrompt);
                num = input.nextInt();

                return (T) intUserInputRetriever.produceOutputOnIntUserInput(num);
            }
            catch(IllegalArgumentException e) {
                System.out.println(num + " is not a valid input");
            }
            catch(InputMismatchException e) {
                System.out.println("Input must be an int");
                input.nextLine();
            }
        }
    }

    public boolean shouldSimulate() {
        String userPrompt = "Enter 1 to CONTINUE simulation or 0 to EXIT program:";

        IntUserInputRetriever<Boolean> intUserInputRetriever = selection -> {
            switch(selection) {
                case 1:
                    if (customer.getMoney() < menu.getLowestCostFood().getPrice()) {
                        System.out.println("You don't have enough money to continue shopping :( - ending simulation...");
                        return false;
                    }
                    return true;
                case 0:
                    System.out.println("ending simulation...");
                    return false;
                default:
                    throw new IllegalArgumentException("Selection is not 0 or 1");
            }
        };

        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public Food getMenuSelection() {
        String userPrompt = "Today's Menu Options!\n\n" + menu.toString();

        IntUserInputRetriever<Food> intUserInputRetriever = selection -> {
            Food food = menu.getFood(selection);

            if(food == null) {
                throw new IllegalArgumentException("Selection is not 0 or 1");
            }

            return food;
        };

        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public boolean isStillOrderingFood() {
        String userPrompt = "Enter 1 to CONTINUE shopping or 0 to CHECKOUT: ";

        IntUserInputRetriever<Boolean> intUserInputRetriever = selection -> {
            switch(selection) {
                case 1:
                    return true;
                case 0:
                    return false;
                default:
                    throw new IllegalArgumentException("Selection is not 0 or 1");
            }
        };

        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
        System.out.println("Processing payment...");

        int totalPrice = shoppingBag.getTotalPrice();
        int remainingMoney = customer.getMoney() - shoppingBag.getTotalPrice();
        System.out.printf("Your remaining money: %d\n", remainingMoney);
        customer.setMoney(remainingMoney);

        System.out.println("Thank you and enjoy your food!");
    }

    public void takeOutPrompt() {
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        int customerMoneyLeft = customer.getMoney();

        do {
            System.out.printf("You have $%d left to spend\n\n", customerMoneyLeft);

            Food food = getMenuSelection();

            if(food.getPrice() < customerMoneyLeft) {
                customerMoneyLeft -= food.getPrice();
                shoppingBag.addItem(food);
            }
            else {
                System.out.println("Oops! Looks like you don't have enough for that.\nChoose another item or checkout.");
            }
        } while (isStillOrderingFood());

        checkoutCustomer(shoppingBag);
    }

    public void startTakeOutSimulator() {
        System.out.println("Hello, welcome to my restaurant!\n");
        System.out.printf("Welcome %s!\n\n", customer.getName());

        takeOutPrompt();
    }
}
