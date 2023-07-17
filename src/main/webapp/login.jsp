<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.regex.Pattern"%>
<%@ page import="java.util.regex.Matcher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<h2>User Login</h2>

	<form action="LoginServlet" method="post">
		<table>
			<tr>
				<td><label for="user">Enter UserName: </label></td>
				<td><input type="text" id="user" name="user"></td>
			</tr>

			<tr>
				<td><label for="password">Enter Password</label></td>
				<td><input type="text" id="password" name="password"></td>
			</tr>
			<tr>
				<td><button type="submit">Login !</button></td>
				<td><strong><a href="register.jsp">Register</a></strong></td>
			</tr>

		</table>

	</form>

</body>
</html>