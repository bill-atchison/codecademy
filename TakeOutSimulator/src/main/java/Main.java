import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Customer customer = new Customer();
        FoodMenu menu = new FoodMenu();


        System.out.print("Enter customer name: ");
        String customerName =input.nextLine();

        int money = 0;
        while(true) {
            System.out.printf("Enter customer money: ");
            try {
                money = input.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Amount!");
                input.nextLine();
            }
        }

        customer.setName(customerName);
        customer.setMoney(money);

        TakeOutSimulator simulator = new TakeOutSimulator(customer, menu, input);
        simulator.startTakeOutSimulator();
    }
}