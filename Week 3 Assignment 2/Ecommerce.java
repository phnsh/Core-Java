import java.util.Collections;
import java.util.Arrays;

abstract class Item {
	public int itemId;
	public String itemName;
	public String itemDesc;
	public double itemPrice;

	public Item(int itemId, String itemName, String itemDesc, double itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
	}
	abstract int getItem();
	abstract double getPrice();
}

class Mobile extends Item {
	public Mobile(int itemId, String itemName, String itemDesc, double itemPrice) {
		super(itemId, itemName, itemDesc, itemPrice);
	}

	@Override
	public int getItem() {
		return this.itemId;
	}

	@Override
	public double getPrice() {
		return this.itemPrice;
	}
}

class Fashion extends Item {
	public Fashion(int itemId, String itemName, String itemDesc, double itemPrice) {
		super(itemId, itemName, itemDesc, itemPrice);
	}

	@Override
	public int getItem() {
		return this.itemId;
	}

	@Override
	public double getPrice() {
		return this.itemPrice;
	}
}

class Seller {
	private static int itemCount = 0;
	private Object[] items;

	private int sellerId;
	private String sellerName;
	private String sellerAddress;
	private long sellerContactDetails;
	
	public Seller(int sellerId, String sellerName, String sellerAddress, long sellerContactDetails) {
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerAddress = sellerAddress;
		this.sellerContactDetails = sellerContactDetails;
	}

	public void sellItems(Object ...obj) {
		this.items = obj;
		itemCount = items.length;
	}
	public int getItemCount() {
		return items.length;
	}
}

class User {
	private int userId;
	private String userName;
	private String userAddress;
	private long userContactDetails;

	public User(int userId, String userName, String userAddress, long userContactDetails) {
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userContactDetails = userContactDetails;
	}

	public String getUserName() {
		return this.userName;
	}
}

class Cart {
	public Object user;
	public int quantity;
	public Object item;

	public Cart() {};
	
	public Cart(Object user, int quantity, Object item) {
		this.user = user;
		this.quantity = quantity;
		this.item = item;
	}
	public Object getItem() {
		return this.item;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public Object getUser() {
		return this.user;
	}
}

class Checkout extends Cart {
	private int noOfItems = 0;
	private double price;
	private String userName;
	private double total = 0;
	public void checkoutCartItems(Cart ...carts) {
		for(int i = 0; i < carts.length; i++) {
			if(carts[i].getItem() instanceof Mobile) {
				Mobile mob = (Mobile)carts[i].getItem();
				User user = (User)carts[i].getUser();
				this.noOfItems = carts[i].getQuantity();
				this.price = getItemPrice(mob);
				this.userName = getUserName(user);
				calacTotal();
			}
			else if(carts[i].getItem() instanceof Fashion) {
				Fashion fash = (Fashion)carts[i].getItem();
				User user = (User)carts[i].getUser();
				this.noOfItems = carts[i].getQuantity();
				this.price = getItemPrice(fash);
				this.userName = getUserName(user);
				calacTotal();
			}
		}
	}

	private double getItemPrice(Mobile mobile) {
		return mobile.getPrice();
	}

	private double getItemPrice(Fashion fashion) {
		return fashion.getPrice();
	}

	private String getUserName(User user) {
		return user.getUserName();
	}
	private void calacTotal() {
		total = total + (price * noOfItems);
	}
	public double getTotalPrice() {
		return total;
	}
}

interface PaymentTypes {
	void payWithDebit();
	void payWithCredit();
	void payWithNetBanking();
	void payWithWallet();
}

class Payment extends Checkout implements PaymentTypes {
	private double price;
	private int orderId;

	public Payment(Checkout price) {
		//generating random numbers
		String[] arr = {"1","2","3","4","5","6","7","8","9","0"};
		Collections.shuffle(Arrays.asList(arr));
		StringBuilder stringBuilder = new StringBuilder();
		for(String letter: arr) {
			stringBuilder.append(letter);
		}
		orderId = Integer.parseInt(stringBuilder.toString().substring(0, 6));
		System.out.println("Order ID: " + orderId);
		this.price = price.getTotalPrice();
	}

	@Override
	public void payWithDebit() {
		System.out.println("Paid " + this.price + " using Debit card");
	}

	@Override
	public void payWithCredit() {
		System.out.println("Paid " + this.price + " using Credit card");
	}

	@Override
	public void payWithNetBanking() {
		System.out.println("Paid " + this.price + " using Net banking");
	}

	@Override
	public void payWithWallet() {
		System.out.println("Paid " + this.price + " using Wallet");
	}
}