<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(365 * 24 * 60 * 60);
		response.addCookie(cookie);
	%>
	<p><a href="ShowCookie.jsp">Next Page to view the 
cookie value</a><p>
</body>
</html>