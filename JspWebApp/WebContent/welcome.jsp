<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- writer.write("<html>"); -->
<html>
<!-- writer.write("<head>"); -->
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = session.getAttribute("username").toString();
	 request.getMethod();
	%>
	<h1>Congratulation! Successfully Logged In</h1>
	<h2>Hello <%=username%></h2>
</body>
</html>