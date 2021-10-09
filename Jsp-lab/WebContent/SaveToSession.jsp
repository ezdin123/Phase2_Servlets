<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		session.setAttribute("attributeUserName", username);
	%>
	
	<p>
		<a href="ShowSessionData.jsp">Next Page to view the session value</a>
	<p>
</body>
</html>