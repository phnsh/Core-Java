class Fashion extends Item implements Comparable {
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}