package com.greatlearning.fsd.twitterapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCConnection {
	
	private static final String CONNECT_STRING = "jdbc:mysql://localhost:3306/twitter_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static Optional<Connection> getConnection() {
		try {
			return Optional.of(DriverManager.getConnection(CONNECT_STRING, USERNAME, PASSWORD));
		} catch (SQLException e) {
			System.out.println("Exception while connection to the DB");
			e.printStackTrace();
		}
		return Optional.ofNullable(null);
	}
}