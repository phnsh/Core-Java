class Checkout extends Cart implements Comparable {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + noOfItems;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checkout other = (Checkout) obj;
		if (noOfItems != other.noOfItems)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Checkout [noOfItems=" + noOfItems + ", price=" + price + ", userName=" + userName + ", total=" + total
				+ "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}