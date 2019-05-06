import Component;
import Cart;
import Discount;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

class LaptopBuilder {

    static void displayOptions(Component[] comp) {
        for (int i = 0; i < comp.length; i++) {
            System.out.println(i + ". " + comp[i].label + " : RM" + comp[i].price);
        }
    }

    static void displayCart(ArrayList<Cart> cart) {
        System.out.println("The laptop(s) available in your cart");

        for (int i = 0; i < cart.size(); i++) {
            System.out.println("Laptop - " + i);
            System.out.println("Base Price - RM" + cart.get(i).basePrice); 
            System.out.println("Screen - " + cart.get(i).screen + " : RM" + cart.get(i).screenPrice);
            System.out.println("RAM - " + cart.get(i).ram + " : RM" + cart.get(i).ramPrice);
            System.out.println("HDD - "  + cart.get(i).hdd + " : RM" + cart.get(i).hddPrice);
            System.out.println("Processor - " + cart.get(i).processor + " : RM" + cart.get(i).processorPrice);
            System.out.println("Unit Price - RM" + cart.get(i).unitPrice);
            System.out.println("---------------------------------");
        }
    }

    static int getTotalPrice(ArrayList<Cart> cart) {
        int totalPrice = 0;
        for (int i = 0; i < cart.size(); i++) {
            totalPrice += cart.get(i).unitPrice;
        }
        return totalPrice;
    }

    static double getDiscountedPrice(int totalPrice, String discountCode, Discount[] discount) {
        for (int i = 0; i < discount.length; i++) {
            if (discount[i].code.equals(discountCode)) {
                return totalPrice - (totalPrice * discount[i].percentage/100);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        
        ArrayList<Cart> cart = new ArrayList<Cart>();
        int basePrice = 1000;
        boolean isCompleted = false;
        int index = 0;
        int totalPrice = 0;
        
        Component[] screenComp = new Component[3];
        screenComp[0] = new Component("1080p", 300);
        screenComp[1] = new Component("4k", 400);
        screenComp[2] = new Component("Touchscreen", 500);

        Component[] ramComp = new Component[3];
        ramComp[0] = new Component("8GB", 100);
        ramComp[1] = new Component("16GB", 200);
        ramComp[2] = new Component("32GB", 300);

        Component[] hddComp = new Component[3];
        hddComp[0] = new Component("128GB SSD", 200);
        hddComp[1] = new Component("256GB SSD", 300);
        hddComp[2] = new Component("512GB SSD", 400);

        Component[] processorComp = new Component[3];
        processorComp[0] = new Component("i3", 200);
        processorComp[1] = new Component("i5", 400);
        processorComp[2] = new Component("i7", 600);

        Discount[] discount = new Discount[3];
        discount[0] = new Discount("DC5", 5);
        discount[1] = new Discount("DC10", 10);
        discount[2] = new Discount("DC15", 15);

        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to ABC Computer Shop");
    
        while(!isCompleted) {
            int unitPrice = basePrice;

            System.out.println("Laptop base price is RM" + basePrice);
            System.out.println("Please select the Screen option: ");
            displayOptions(screenComp);

            index = Integer.parseInt(userInput.nextLine());
            
            String screenOption = screenComp[index].label;
            int screenPrice = screenComp[index].price;

            unitPrice += screenPrice;

            System.out.println("Please select the RAM option: ");
            displayOptions(ramComp);

            index = Integer.parseInt(userInput.nextLine());

            String ramOption = ramComp[index].label;
            int ramPrice = ramComp[index].price;

            unitPrice += ramPrice;

            System.out.println("Please select the HDD option: ");
            displayOptions(hddComp);

            index = Integer.parseInt(userInput.nextLine());

            String hddOption = hddComp[index].label;
            int hddPrice = hddComp[index].price;

            unitPrice += hddPrice;

            System.out.println("Please select the Processor option: ");
            displayOptions(processorComp);

            index = Integer.parseInt(userInput.nextLine());

            String processorOption = processorComp[index].label;
            int processorPrice = processorComp[index].price;

            unitPrice += processorPrice;

            cart.add(new Cart(screenOption, screenPrice, ramOption, ramPrice,
                hddOption, hddPrice, processorOption, processorPrice, unitPrice, basePrice));

            System.out.println("Checkout your cart(Y or N)?");

            String decision = userInput.nextLine().toUpperCase();

            if (decision.equals("Y")) {
                isCompleted = true;
            }
            if (decision.equals("N")) {
                isCompleted = false;
            }
        }
        
        displayCart(cart);

        totalPrice = getTotalPrice(cart);

        System.out.println("Total price is RM" + totalPrice);

        System.out.println("Please enter discount code if available");

        String discountCode = userInput.nextLine().toUpperCase();

        if(getDiscountedPrice(totalPrice, discountCode, discount) > 0) {
            System.out.println("Total price after discount is RM" + getDiscountedPrice(totalPrice, discountCode, discount));
        } else {
            System.out.println("Total price is RM" + totalPrice);
        }
    }
}