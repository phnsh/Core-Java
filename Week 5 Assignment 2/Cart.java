class Cart implements Comparable {
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}