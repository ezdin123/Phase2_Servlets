<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="com.model.LoginDao"%>
	<jsp:useBean id="obj" class="com.model.LoginBean" />

	<jsp:setProperty property="*" name="obj" />

	<%
		boolean status = LoginDao.validate(obj);
		if (status) {
			out.println("You r successfully logged in");
			session.setAttribute("session", "TRUE");
		} else {
			out.print("Sorry, email or password error");
	%>
	<jsp:include page="index.jsp"></jsp:include>
	<%
		}
	%>
</body>
</html>