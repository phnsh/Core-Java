package com.greatlearning.fsd.twitterapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import com.greatlearning.fsd.twitterapp.model.Tweet;
import com.greatlearning.fsd.twitterapp.model.User;

public class JDBCImpl implements UserService {
	
	Optional<Connection> optionalConnection = JDBCConnection.getConnection();
	
	@Override
	public void createUser(String userHandle, String password, String emailAddress, String firstName, String lastName) {
		//new User(userHandle, password, emailAddress, firstName, lastName);
		Connection connection = optionalConnection.get();
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement(
					"insert into twitter_user(user_name, user_id, user_handle, following_, followers, password, user_email_address) values(?, ?, ?, ?, ?, ?");
			connection.setAutoCommit(false);
			prepareStatement.setString(1, firstName + lastName);
			prepareStatement.setInt(2, 0);
			prepareStatement.setString(3, userHandle);
			prepareStatement.setInt(4, 0);
			prepareStatement.setInt(5, 0);
			prepareStatement.setString(6, password);
			prepareStatement.setString(7, emailAddress);
			prepareStatement.addBatch();
			
			prepareStatement.executeBatch();
			connection.commit();
			System.out.println("User created");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loginUser(String username, String password) {
		Connection connection = optionalConnection.get();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from twitter_user where user_name=? and password=?");
			connection.setAutoCommit(false);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			int isLoggedIn[] = preparedStatement.executeBatch();
			if(isLoggedIn.length == 1) {
				connection.commit();
				System.out.println("User " + username + " logged in");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addTweet(int userId, String tweet) {
		Connection connection = optionalConnection.get();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into tweet_data(tweet_id, tweet_content, tweet_likes, tweet_comment) values(0,?,?,?");
			connection.setAutoCommit(false);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, tweet);
			preparedStatement.setInt(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.executeBatch();
			connection.commit();
			System.out.println("Tweeted");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

}
