package com.greatlearning.fsd.twitterapp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Comparable<User>{
	private final long userId;
	private final String userHandle;
	private String firstName;
	private String lastName;
	private String password;
	private final Set<User> followers = new HashSet();
	private final Set<User> following = new HashSet();
	private final Date createDt;
	private Date updateDt;
	private String emailAddress;
	private String profilePic;
	private String coverImage;
	private static long userIdCount = 1000;
	
	public User(String userHandle, String password, String emailAddress, String firstName, String lastName) {
		this.userId = ++userIdCount;
		this.password = password;
		this.userHandle = userHandle;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createDt = null;
	}

	public User(long userId, String userHandle, String firstName, String lastName, String password, Date createDt,
			String emailAddress, String profilePic, String coverImage) {
		super();
		this.userId = userId;
		this.userHandle = userHandle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.createDt = createDt;
		this.emailAddress = emailAddress;
		this.profilePic = profilePic;
		this.coverImage = coverImage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<User> getFollowers() {
		return followers;
	}

	public Set<User> getFollowing() {
		return following;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public long getUserId() {
		return userId;
	}

	public String getUserHandle() {
		return userHandle;
	}

	public Date getCreateDt() {
		return createDt;
	}
	
	public void follow(User User) {
		
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coverImage == null) ? 0 : coverImage.hashCode());
		result = prime * result + ((createDt == null) ? 0 : createDt.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((followers == null) ? 0 : followers.hashCode());
		result = prime * result + ((following == null) ? 0 : following.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profilePic == null) ? 0 : profilePic.hashCode());
		result = prime * result + ((updateDt == null) ? 0 : updateDt.hashCode());
		result = prime * result + ((userHandle == null) ? 0 : userHandle.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		if (coverImage == null) {
			if (other.coverImage != null)
				return false;
		} else if (!coverImage.equals(other.coverImage))
			return false;
		if (createDt == null) {
			if (other.createDt != null)
				return false;
		} else if (!createDt.equals(other.createDt))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (followers == null) {
			if (other.followers != null)
				return false;
		} else if (!followers.equals(other.followers))
			return false;
		if (following == null) {
			if (other.following != null)
				return false;
		} else if (!following.equals(other.following))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profilePic == null) {
			if (other.profilePic != null)
				return false;
		} else if (!profilePic.equals(other.profilePic))
			return false;
		if (updateDt == null) {
			if (other.updateDt != null)
				return false;
		} else if (!updateDt.equals(other.updateDt))
			return false;
		if (userHandle == null) {
			if (other.userHandle != null)
				return false;
		} else if (!userHandle.equals(other.userHandle))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userHandle=" + userHandle + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", followers=" + followers + ", following=" + following
				+ ", createDt=" + createDt + ", updateDt=" + updateDt + ", emailAddress=" + emailAddress
				+ ", profilePic=" + profilePic + ", coverImage=" + coverImage + "]";
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}