public class PizzaShop_W2A2_1_v2 {
    private String crustType;
    private String toppingType;
    private String sidesType;
    private int offers;
    private boolean offerApplied = false;
    private double price;
    private double discount;

    private int crustTypeAmount;
    //crusttype, toppings, sides, offers, price
    PizzaShop_W2A2_1_v2(String crust, String topping, String sides) {
        crustType = crust;
        toppingType = topping;
        sidesType = sides;
    }

    PizzaShop_W2A2_1_v2(String crust, String topping, String sides, int offer) {
        crustType = crust;
        toppingType = topping;
        sidesType = sides;
        offers = offer;
        offerApplied = true;
    }

    // private int getCrustPrice() {
    //     switch(crustType) {
    //         case "thinCrust":
    //             crustTypeAmount = 100;
    //             break;
    //         case "cheeseBurst":
    //             crustTypeAmount = 200;
    //             break;
    //         case "classicPan":
    //             crustTypeAmount = 300;
    //             break;
    //     }
    // }

    public double calculateTotalPrice() {
        //logic to calculate price here
        return price;
    }
    public static void main(String arg[]) {
        //(crustType, toppingType, sidesType)
        PizzaShop_W2A2_1_v2 pizzaWithoutOffer = new PizzaShop_W2A2_1_v2("Thin Crust", "Corn", "Fries");
        System.out.println("Total price: " + pizzaWithoutOffer.calculateTotalPrice());

        //20% off applied
        //(crustType, toppingType, sidesType, offerDiscount)
        PizzaShop_W2A2_1_v2 pizzaWithOfferApplied = new PizzaShop_W2A2_1_v2("Thin Crust", "Cheese Burst", "Classic Pan", 20);
        System.out.println("Total price: " + pizzaWithOfferApplied.calculateTotalPrice());
    }
}