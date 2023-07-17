<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register in Our WebSite</title>
</head>
<body>
	<div>
		<form action="RegisterServlet" method="post">
			<table>
				<tr>
					<td><label for="username">Enter Your UserName: </label></td>
					<td><input type="text" id="username" name="username"
						placeholder="Eg. Solo-Squad" required></td>
				</tr>
				<tr>
					<td><label for="password">Enter Your Password: </label></td>
					<td><input type="text" id="password" name="password"
						placeholder="Strong Password" required></td>
				</tr>
				<tr>
					<td><label for="conPassword">Confirm Password: </label></td>
					<td><input type="password" id="conPassword" name="conPassword" required></td>
				</tr>
				<tr>
					<td><label for="email">Enter Your Email: </label></td>
					<td><input type="email" id="email" name="email" required></td>
				</tr>
				
				<tr>
					<td><label for="phone">Enter Your Phone Number: </label></td>
					<td><input type="tel" id="phone" name="phone" required ></td>
				</tr>
				
				<tr>
				<td colspan='2'><button type="submit">Register !</button></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>