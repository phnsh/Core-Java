package com.greatlearning.fsd.twitter.service;

import com.greatlearning.fsd.twitter.model.Tweet;
import com.greatlearning.fsd.twitter.model.User;

import java.util.*;

public class UserServiceImpl implements UserService {

    private static Map<Long, User> users = new HashMap<>();
    private static UserServiceImpl userService = new UserServiceImpl();

    private UserServiceImpl(){

    }

    public static UserServiceImpl getInstance(){
        return userService;
    }

    @Override
    public User createUser(String userName, String firstName, String lastName, String email) {
        User user = new User(userName, firstName, lastName, email);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User createUser(String userName, String firstName, String lastName, String email, String profileImgUrl, String coverUrl) {
        User user = new User(userName, firstName, lastName, email, profileImgUrl, coverUrl);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(long userId, User user) {
        User returnedUser = findById(userId);
        if(returnedUser != null){
            user.setUpdatedDt(new Date());
            users.put(userId, user);
        }
        return returnedUser;
    }

    @Override
    public User findById(long userId) {
        return users.get(userId);
    }

    @Override
    public void authenticateUser(String username, String password) {
        User user = findUserByUserName(username);
        if (user == null ){
            throw new IllegalArgumentException("User does not exists");
        }
        if (! password.equals(user.getPassword())){
            throw new IllegalArgumentException(" Username/password does not match");
        }

    }

    @Override
    public Set<Tweet> fetchTweetsByUser(long userId) {
        User user = findById(userId);
        if(user == null){
            throw new IllegalArgumentException("Invalid User Id ");
        }
        return user.getTweets();
    }

    @Override
    public Set<User> suggestUsers(long userId) {
        if(findById(userId) == null){
            throw new IllegalArgumentException("Invalid User Id");
        }
        Set<Map.Entry<Long, User>> entries = users.entrySet();
        Set<User> suggestedUsers = new HashSet<>();
        Iterator<Map.Entry<Long, User>> iterator = entries.iterator();
        User selectedUser = null;
        while (iterator.hasNext()){
            Map.Entry<Long, User> entry = iterator.next();
            long currentUserId = entry.getKey();
            if(userId == currentUserId){
                continue;
            }
            suggestedUsers.add(entry.getValue());

        }
        return suggestedUsers;
    }

    @Override
    public Set<User> fetchFollowersByUserId(long userId) {
        User user = findById(userId);
        if (user == null ){
            throw new IllegalArgumentException("User does not exists");
        }
        return user.getFollowers();
    }

    @Override
    public User findUserByUserName(String userName){
        Set<Map.Entry<Long, User>> entries = users.entrySet();
        Iterator<Map.Entry<Long, User>> iterator = entries.iterator();
        User selectedUser = null;
        while (iterator.hasNext()){
            Map.Entry<Long, User> entry = iterator.next();
            User user = entry.getValue();
            if(user.getUserName().equals(userName)){
                selectedUser = user;
                break;
            }
        }
        return selectedUser;
    }

    @Override
    public void addFollower(long userId, User user) {
        User fetchedUser = findById(userId);
        if (fetchedUser == null ){
            throw new IllegalArgumentException("User does not exists");
        }
        fetchedUser.addFollower(user);
    }

    @Override
    public Set<Tweet> fetchTweetsByFollowers(long userId){
        User fetchedUser = findById(userId);
        Set<Tweet> tweetsByFollowers = new HashSet<>();
        if (fetchedUser == null ){
            throw new IllegalArgumentException("User does not exists");
        }
        Set<User> followers = fetchedUser.getFollowers();
        if (!followers.isEmpty()){
            Iterator<User> followersIt = followers.iterator();
            while(followersIt.hasNext()){
                User user = followersIt.next();
                tweetsByFollowers.addAll(user.getTweets());
            }
        }
        return tweetsByFollowers;
    }
}