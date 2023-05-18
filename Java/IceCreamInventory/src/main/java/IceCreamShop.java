import java.util.Scanner;

class ShopItems {
    int totalCount;

    class NonVegan {
        int iceCreamCount;
        int shakeCount;
        int totalCount;

        public void increaseCount(int type, int count) {
            switch(type) {
                case 1: iceCreamCount += count;
                        break;
                case 2: shakeCount += count;
                        break;
            }

            totalCount += count;
            ShopItems.this.totalCount += count;
        }
    }

    class Vegan {
        int smoothieCount;
        int slushieCount;
        int totalCount;

        public void increaseCount(int type, int count) {
            switch(type) {
                case 3: smoothieCount += count;
                    break;
                case 4: slushieCount += count;
                    break;
            }

            totalCount += count;
            ShopItems.this.totalCount += count;
        }
    }
}

public class IceCreamShop {

    public static void main(String[] args) {
        int orderType = 0;
        Scanner input = new Scanner(System.in);
        int itemCount = 0;
        String itemName;

        ShopItems shopItems = new ShopItems();
        ShopItems.NonVegan nonVegan = shopItems.new NonVegan();
        ShopItems.Vegan vegan = shopItems.new Vegan();

        System.out.println("Hello!\n Welcome to the ice cream shop.\n We are ready to take your order.\n For ice-cream type 1,\n for shakes type 2,\n for smoothies type 3,\n and for slushies type 4.\n If you are done ordering type 0.");
        orderType = input.nextInt();

        while(orderType != 0) {
            System.out.println("How many items of this item would you like to order?");
            itemCount = input.nextInt();
            if(orderType == 1){
                itemName = "ice cream";
                nonVegan.increaseCount(orderType, itemCount);
            } else if(orderType == 2) {
                itemName = "shake";
                nonVegan.increaseCount(orderType, itemCount);
            } else if(orderType == 3) {
                itemName = "smoothie";
                vegan.increaseCount(orderType, itemCount);
            } else if(orderType == 4) {
                itemName = "slushie";
                vegan.increaseCount(orderType, itemCount);
            } else {
                break;
            }

            System.out.println("Adding " + itemCount + " of the item "+ itemName + " to your order!");

            System.out.println("Type a number for the next item in your order:\n1: Ice cream\n2: Shake\n3: Smoothie\n4: Slushie\n");
            orderType = input.nextInt();
        }

        System.out.printf("Thank you for your order! Today we have sold %d orders of sweetness!\n", shopItems.totalCount);

        System.out.printf("%d items have been ice cream and shakes.\n", nonVegan.totalCount);

        System.out.printf("%d items have been smoothies and slushies.\n", vegan.totalCount);
    }
}
