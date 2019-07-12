class User implements Comparable {
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = prime * result + (int) (userContactDetails ^ (userContactDetails >>> 32));
		result = prime * result + userId;
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
		User other = (User) obj;
		if (userAddress == null) {
			if (other.userAddress != null)
				return false;
		} else if (!userAddress.equals(other.userAddress))
			return false;
		if (userContactDetails != other.userContactDetails)
			return false;
		if (userId != other.userId)
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
		return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress
				+ ", userContactDetails=" + userContactDetails + "]";
	}
	
}