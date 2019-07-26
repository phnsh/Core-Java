package com.greatlearning.fsd.twitterapp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tweet {
	private final long id;
	private String tweetMsg;
	private List<Media> mediaUrls;
	private User user;
	private static long tweetIdCounter = 1000;
	private Date createdDate;
	private final Set<Tweet> tweets = new HashSet();
	private int likes;
	private int shares;
	private int retweets;
	
	public Set<Tweet> getTweets() {
		return tweets;
	}

	public Tweet(User user, String tweetMsg, List<Media> mediaUrls) {
		this.id = ++tweetIdCounter;
		this.user = user;
		this.tweetMsg = tweetMsg;
		this.mediaUrls = mediaUrls;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mediaUrls == null) ? 0 : mediaUrls.hashCode());
		result = prime * result + ((tweetMsg == null) ? 0 : tweetMsg.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Tweet other = (Tweet) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id != other.id)
			return false;
		if (mediaUrls == null) {
			if (other.mediaUrls != null)
				return false;
		} else if (!mediaUrls.equals(other.mediaUrls))
			return false;
		if (tweetMsg == null) {
			if (other.tweetMsg != null)
				return false;
		} else if (!tweetMsg.equals(other.tweetMsg))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	public int compareTo(Tweet tweet) {
		return this.tweetMsg.compareTo(tweet.tweetMsg);
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", tweetMsg=" + tweetMsg + ", mediaUrls=" + mediaUrls + ", user=" + user
				+ ", createdDate=" + createdDate + "]";
	}

	public Tweet(User user, String tweetMsg) {
		this.id = ++tweetIdCounter;
		this.user = user;
		this.tweetMsg = tweetMsg;
	}
	
	public String getTweetMsg() {
		return tweetMsg;
	}

	public void setTweetMsg(String tweetMsg) {
		this.tweetMsg = tweetMsg;
	}

	public List<Media> getMediaUrls() {
		return mediaUrls;
	}

	public void setMediaUrls(List<Media> mediaUrls) {
		this.mediaUrls = mediaUrls;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getTweetIdCounter() {
		return tweetIdCounter;
	}

	public static void setTweetIdCounter(long tweetIdCounter) {
		Tweet.tweetIdCounter = tweetIdCounter;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getId() {
		return id;
	}

	enum MediaType {
		AUDIO,
		VIDEO,
		IMAGE;
	}
	
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getRetweets() {
		return retweets;
	}

	public void setRetweets(int retweets) {
		this.retweets = retweets;
	}

	//aggregation
	class Media {
		private MediaType mediaType;
		private String url;
		
		public Media(MediaType mediaType, String url) {
			this.mediaType = mediaType;
			this.url = url;
		}
	}
}