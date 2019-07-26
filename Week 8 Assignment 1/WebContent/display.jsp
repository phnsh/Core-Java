<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="com.greatlearning.servets.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
	<table border="1" width="500" align="center">
		<tr bgcolor="f0f0f0">
			<th><b>User ID</b></th>
			<th><b>User Name</b></th>
			<th><b>User Age</b></th>
			<th><b>User Location</b></th>
		</tr>
		<%
		ArrayList<User> arrayList = (ArrayList<User>)request.getAttribute("name");
		for(User user: arrayList) {%>
		<tr>
			<td><%= user.getId() %></td>
			<td><%= user.getName() %></td>
			<td><%= user.getAge() %></td>
			<td><%= user.getLocation() %></td>
		</tr>
		<%}
	%>
	</table>
</body>
</html>