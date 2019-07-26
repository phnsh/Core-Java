package com.greatlearning.fsd.twitterapp.client;

import java.util.Scanner;

import com.greatlearning.fsd.twitterapp.model.Tweet;
import com.greatlearning.fsd.twitterapp.model.User;
import com.greatlearning.fsd.twitterapp.service.JDBCImpl;
import com.greatlearning.fsd.twitterapp.service.UserService;

public class Client {
	static Scanner sc;
	static User user;
	private static UserService userService = new JDBCImpl();
	public static void main(String args[]) {
		//UserService userService = new JDBCImpl();
		System.out.println("Please select from the following options");
		System.out.println("1 -> Signup");
		System.out.println("2 -> Login");
		
		sc = new Scanner(System.in);
		int option = sc.nextInt();
		User user = null;
		switch(option) {
		case 1: 
			createUserAccount();
			break;
		case 2:
			userLogin();
			break;
		case 3:
			
		}
	}
	
	public static void createUserAccount() {
		System.out.println("Enter userhandle: ");
		String userHandle = sc.next();
		
		System.out.println("\nEmail address: ");
		String emailAddress = sc.next();
		
		System.out.println("\nPassword: ");
		String password = sc.next();
		
		System.out.println("\nFirst name: ");
		String firstName = sc.next();
		
		System.out.println("\nLast name: ");
		String lastName = sc.next();
		
		userService.createUser(userHandle, password, emailAddress, firstName, lastName);
	}
	
	public static void userLogin() {
		System.out.println("Username: ");
		String username = sc.next();
		
		System.out.println("Password: ");
		String password = sc.next();
		
		userService.loginUser(username, password);
	}
	
	public static void postTweet() {
		System.out.println("Enter tweet: ");
		userService.addTweet(0, sc.next());
	}
}