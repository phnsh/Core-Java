package com.greatlearning.fsd.twitter.client;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.greatlearning.fsd.twitter.model.Tweet;
import com.greatlearning.fsd.twitter.model.User;
import com.greatlearning.fsd.twitter.service.UserService;
import com.greatlearning.fsd.twitter.service.UserServiceImpl;

public class Client {

	public static void main(String[] args) {

		UserService userService = UserServiceImpl.getInstance();
		Set<User> users = populateData(userService);
		Scanner scans = new Scanner(System.in);

		System.out.println();
		printEntitySet(users);

		int userInput;
		System.out.println("========== Tweet Interface =========");
		System.out.println("1 => Post a tweet");
		System.out.println("2 => View external tweet feed");
		System.out.println("3 => View my tweets");
		System.out.println("4 => Like a tweet");
		System.out.println("5 => Comment on a tweet");
		System.out.println("====================================");
		userInput = scans.nextInt();
		
		switch(userInput) {
		case 1:
			System.out.println("User name: ");
			String userName = scans.nextLine();
			String userTweet = scans.nextLine();
			new Tweet(userName, userTweet);
			break;
		case 2:
			System.out.println("Twitter feed\n");
			Iterator<User> it = users.iterator();
			while(it.hasNext()){
				User user = it.next();
				if(!user.getTweets().isEmpty()) {
					System.out.println("Tweets by User - " + user.getFirstName());
					printEntitySet(userService.fetchTweetsByUser(user.getId()));
				}
			}
			break;
		case 3:
			System.out.println("View my tweets");
			Iterator<User> it1 = users.iterator();
			while(it1.hasNext()){
				User user = it1.next();
				if(!user.getTweets().isEmpty()) {
					System.out.println("My tweets" + user.getFirstName());
					printEntitySet(userService.fetchTweetsByUser(user.getId()));
				}
			}
			break;
		case 4:
			int i = 1;
			Tweet tweet;
			System.out.println("Like a tweet: ");
			Iterator<User> it11 = users.iterator();
			while(it11.hasNext()){
				User user = it11.next();
				if(!user.getTweets().isEmpty()) {
					System.out.println(i + " " + user.getFirstName());
					printEntitySet(userService.fetchTweetsByUser(user.getId()));
				}
				i++;
			}
			System.out.println("Select a tweet: ");
			int tweetChoice = scans.nextInt();
			Tweet.Stats.setLikes(1);
			break;
		case 5:
			System.out.println("Comment on a tweet: ");
			Iterator<User> it12 = users.iterator();
			while(it12.hasNext()){
				User user = it12.next();
				if(!user.getTweets().isEmpty()) {
					System.out.println(user.getFirstName());
					printEntitySet(userService.fetchTweetsByUser(user.getId()));
				}
			}
			System.out.println("Select a tweet: ");
			int tweetComment = scans.nextInt();
			System.out.println("write a comment below: ");
			String comment = scans.nextLine();
			Tweet.Stats.setComments(1);
		}
	}
	
	private static Set<User> populateData(UserService userService) {
		Set<User> userSet = new HashSet<>();
		User user1 = userService.createUser( "user_1", "Firstname1", "Lastname1", "user1@gmail.com");
		User user2 = userService.createUser( "user_2", "Firstname2", "Lastname2", "user2@gmail.com");

		Tweet tweet1 = new Tweet("Tweet 1");
		Tweet tweet2 = new Tweet("Tweet 2");

		userSet.add(user1);
		userSet.add(user2);
		return userSet;
	}

	private static <E> void printEntitySet(Set<E> entity ){
		Iterator<E> it = entity.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}