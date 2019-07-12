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