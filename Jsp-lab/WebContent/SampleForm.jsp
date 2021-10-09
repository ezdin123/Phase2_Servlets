<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form method="post" action="SaveToSession.jsp">
		<p>
			<b>Enter Your Name: </b> <input type="text" name="username">
			<br> <input type="submit" value="Submit">
	</form>
	
	<%
  if (request.getParameter("error") != null)
          out.println("<b>Your session has expired or is invalid.</b><br>");
%>
	

</body>
</html>