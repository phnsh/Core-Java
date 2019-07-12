import java.util.Arrays;

class Seller implements Comparable {
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(items);
		result = prime * result + ((sellerAddress == null) ? 0 : sellerAddress.hashCode());
		result = prime * result + (int) (sellerContactDetails ^ (sellerContactDetails >>> 32));
		result = prime * result + sellerId;
		result = prime * result + ((sellerName == null) ? 0 : sellerName.hashCode());
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
		Seller other = (Seller) obj;
		if (!Arrays.equals(items, other.items))
			return false;
		if (sellerAddress == null) {
			if (other.sellerAddress != null)
				return false;
		} else if (!sellerAddress.equals(other.sellerAddress))
			return false;
		if (sellerContactDetails != other.sellerContactDetails)
			return false;
		if (sellerId != other.sellerId)
			return false;
		if (sellerName == null) {
			if (other.sellerName != null)
				return false;
		} else if (!sellerName.equals(other.sellerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seller [items=" + Arrays.toString(items) + ", sellerId=" + sellerId + ", sellerName=" + sellerName
				+ ", sellerAddress=" + sellerAddress + ", sellerContactDetails=" + sellerContactDetails + "]";
	}
	
	
}