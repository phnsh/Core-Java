package com.greatlearning.fsd.twitter.service;

import com.greatlearning.fsd.twitter.model.Tweet;
import com.greatlearning.fsd.twitter.model.User;
import java.util.Set;

public interface UserService {

    User createUser(String userName, String firstName, String lastName, String email);

    User createUser(String userName, String firstName, String lastName, String email, String profileImgUrl, String coverUrl);

    User updateUser(long userId, User user);

    User findById(long userId);

    void authenticateUser(String username, String password);

    Set<Tweet> fetchTweetsByUser(long userId);

    Set<User> suggestUsers(long userId);

    Set<User> fetchFollowersByUserId(long userId);

    User findUserByUserName(String userName);

    void addFollower(long userId, User user);

    Set<Tweet> fetchTweetsByFollowers(long userId);
}