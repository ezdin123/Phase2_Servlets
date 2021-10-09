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
		String cookieName = "username";
		Cookie cookies[] = request.getCookies();
		Cookie myCookie = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(cookieName)) {
				myCookie = cookies[i];
				break;
			}
		}
	%>


	<%
		if (myCookie == null) {
	%>
	No Cookie found with the name
	<%=cookieName%>
	<%
		} else {
	%>
	<p>
		Welcome Dear
		<%=myCookie.getValue()%>.
		<%
		}
	%>
	
</body>
</html>