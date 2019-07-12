class Mobile extends Item implements Comparable {
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Mobile [itemId=" + itemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", itemPrice="
				+ itemPrice + ", getItem()=" + getItem() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}