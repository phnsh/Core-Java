package com.greatlearning.servets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(1, "User1", 30, "Goa"));
		userList.add(new User(5, "User2", 25, "Bangalore"));
		userList.add(new User(3, "User3", 47, "Delhi"));
		userList.add(new User(9, "User4", 24, "Mumbai"));
		
		req.setAttribute("name", userList);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/display.jsp");
		requestDispatcher.forward(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
	}
}
