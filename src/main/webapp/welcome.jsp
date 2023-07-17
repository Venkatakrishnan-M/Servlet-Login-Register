<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String nameString = (String) request.getAttribute("name");%>
<h3>WELCOME TO THE WORLD MR: <%=nameString.toUpperCase() %></h3>
</body>
</html>