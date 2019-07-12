import java.util.Arrays;
import java.util.Collections;

class Payment extends Checkout implements PaymentTypes, Comparable {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + orderId;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (orderId != other.orderId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [price=" + price + ", orderId=" + orderId + "]";
	}
	
	
}