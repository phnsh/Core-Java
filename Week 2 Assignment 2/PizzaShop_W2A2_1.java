import java.util.Scanner;

public class PizzaShop_W2A2_1 {
    private String[] crust = {"Thin Crust", "Cheese Burst", "Classic Pan"};
    private int crustOption;
    private int[] crustPrice = {100, 200, 300};

    private String[] toppings = {"Corn", "Chicken", "Paneer", "Pineapple", "Pepperoni"};
    private int toppingsOption;
    private int[] toppingsPrice = {100, 200, 300, 400, 500};

    private String[] sides = {"Coke", "Fries", "Wedges", "Nachos"};
    private int sidesOption;
    private int[] sidesPrice = {100, 200, 300, 400};

    private int[] offerTypes = {20, 50};
    private int offerOption = 0;

    private double price;
    private double discount;
    //crusttype, toppings, sides, offers, price

    public void getPrice() {
        price = crustPrice[crustOption] + toppingsPrice[toppingsOption] + sidesPrice[sidesOption];
        if(offerOption > 0) {
            discount = offerTypes[offerOption - 1] / 100.00;
            discount = price * discount;
            price = price - discount;
        }
        System.out.println("Total: Rs " + price);
    }

    public void setOffer(int option) {
        offerOption = option;
    }

    public void getOffer() {
        for(int i = 0; i < offerTypes.length; i++) {
            System.out.print((i + 1) + " " + offerTypes[i] + "% Off\n");
        }
    }

    public void setSides(int option) {
        sidesOption = option - 1;
    }

    public void getSides() {
        for(int i = 0; i < sides.length; i++) {
            System.out.print((i + 1) + " " + sides[i] + " Rs " + sidesPrice[i] + "\n");
        }
    }

    public void setToppings(int option) {
        toppingsOption = option - 1;
    }

    public void getToppings() {
        for(int i = 0; i < toppings.length; i++) {
            System.out.print((i + 1) + " " + toppings[i] + " Rs " + toppingsPrice[i] + "\n");
        }
    }

    public void setCrust(int option) {
        crustOption = option - 1;
    }

    public void getCrust() {
        for(int i = 0; i < crust.length; i++) {
            System.out.print((i + 1) + " " + crust[i] + " Rs " + crustPrice[i] + "\n");
        }
    }

    public static void main(String args[]) {
        Scanner scans = new Scanner(System.in);
        PizzaShop_W2A2_1 pizzaShop = new PizzaShop_W2A2_1();
        int option;
        String offerGiven;
        System.out.println("Select from below");
        
        System.out.println("Crust:");
        pizzaShop.getCrust();
        option = scans.nextInt();
        pizzaShop.setCrust(option);

        System.out.println("Toppings: ");
        pizzaShop.getToppings();
        option = scans.nextInt();
        pizzaShop.setToppings(option);

        System.out.println("Sides: ");
        pizzaShop.getSides();
        option = scans.nextInt();
        pizzaShop.setSides(option);

        System.out.println("Any discounts to be applied?\ny/n");
        offerGiven = scans.next();
        if(offerGiven.equals("y")) {
            System.out.println("Offers: ");
            pizzaShop.getOffer();
            option = scans.nextInt();
            pizzaShop.setOffer(option);
        }
        pizzaShop.getPrice();
        scans.close();
    }
}