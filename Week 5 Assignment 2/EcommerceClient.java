public class EcommerceClient {
	public static void main(String args[]) {
		/**
		 * Life cycle of an item
		 * add item[1] -> assign items to seller[2] -> user selects items and adds to cart[3] -> checkout/payment[4]
		 */
		Mobile nokia1100 = new Mobile(123, "Nokia 1100", "first M item", 500); //[1]
		Mobile onePlus = new Mobile(156, "OnePlus 7 Pro", "second M item", 600); //[1]
		Fashion suit = new Fashion(245, "Black suit", "first F item", 300); //[1]
		Fashion tie = new Fashion(287, "Grey Tie", "second F item", 100); //[1]
		
		Seller seller1 = new Seller(757, "seller1", "selleraddress1", 7881992310L);
		seller1.sellItems(nokia1100, onePlus, suit, tie); //[2]
		
		User user1 = new User(984, "user1", "useraddress1", 9981998110L); //new user
		
		//Cart(user's object, quantity, item)
		Cart cart1 = new Cart(user1, 2, nokia1100); //[3]
		Cart cart2 = new Cart(user1, 1, onePlus); //[3]
		Cart cart3 = new Cart(user1, 1, suit); //[3]

		Checkout checkout = new Checkout();
		checkout.checkoutCartItems(cart1, cart2, cart3); //[4]
		System.out.println("Total price: " + checkout.getTotalPrice()); //total price
		Payment payment = new Payment(checkout);
		payment.payWithNetBanking(); //[4]
	}
}