package com.greatlearning.fsd.twitterapp.service;

import com.greatlearning.fsd.twitterapp.model.Tweet;
import com.greatlearning.fsd.twitterapp.model.User;

public interface UserService {
	
	void createUser(String userHandle, String password, String emailAddress, String firstName, String lastName);
	void loginUser(String username, String password);
	void addTweet(int userId, String tweet);
}