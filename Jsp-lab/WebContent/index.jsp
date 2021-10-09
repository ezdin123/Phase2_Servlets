
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page errorPage="handle-error.jsp"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Implicit Objects</title>
</head>
<body>
<hr>
<hr>
//<a href="login.jsp">login</a>|  
<a href="logout.jsp">logout</a>|  
<a href="profile.jsp">profile</a>

<hr>
<hr>

<br>
	<%
		String responseCheck = request.getParameter("office");
		if (responseCheck != null) {
			//response.setStatus(response.SC_MOVED_TEMPORARILY);
			//response.setHeader("Location", "response-redirect.jsp?office=" + responseCheck);
			response.sendRedirect("response-redirect.jsp?office=" + responseCheck);
		}

		String errorCheck = request.getParameter("error");
		if (errorCheck != null) {
			int x = 0;
			if (x == 0)
				throw new RuntimeException("Exception has been raised");
		}
	%>
		<br>
	<br>
	<a href="index.jsp?office=head_office">Show usage of response
		object</a>
	<br>
	<a href="index.jsp?error=1">Show usage of error object</a>
	<br>
	<br>
	<a href="index.jsp?error=1">Show usage of error object</a>
	<br>

	<br>
	<a href="getName.html">Show name</a>
	<br>
	<br>
	<a href="CookieForm.jsp">Show cookies</a>
	<br>
	<br>
	<a href="SampleForm.jsp">Show sessions</a>login.jsp
	<br>

	<%
		if (response.containsHeader("Office"))
			out.println("Current location is " + response.getHeader("Office"));
	%>
	<%-- This is to demonstrate out and request objects --%>
	<%
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			out.println("<p><b>" + name + "</b>: " + value + "</p>");
		}
	%>
	<%-- Demonstrating the request object --%>
	<table border=1 cellspacing=0 cellpadding=2>
		<%
			String strHeaderName = "";
			java.util.Enumeration<String> e = request.getHeaderNames();
			while (e.hasMoreElements()) {
				strHeaderName = e.nextElement();
		%>
		<tr>
			<td><%=strHeaderName%></td>
			<td><%=request.getHeader(strHeaderName)%></td>
		</tr>
		<%
			}
		%>
	</table>

	<b>Current Date and Time is: <font color="#FF0000"> <%=new Date()%>
	</font>
	</b> This is content from the index file.
	<%@ include file="included.jsp"%>
	<hr>
	Example of using JSTL taglibs for formatting output
	<br>
	<p>
		Currency =
		<fmt:formatNumber value="145" type="currency" />
	<p>
	<p>
		<c:set var="now" value="<%=new java.util.Date()%>" />
		Current date and time is
		<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${now}" />
	</p>

	<c:forTokens items="Rahul-Nakul-Rajesh" delims="-" var="name">
		<c:out value="${name}" />
		<p>
	</c:forTokens>
	<c:catch var="catchtheException">
		<%
			int x = 2 / 0;
		%>
	</c:catch>

	<c:if test="${catchtheException != null}">
		<p>
			The type of exception is : ${catchtheException} <br /> There is an
			exception: ${catchtheException.message}
		</p>
	</c:if>
</body>
</html>