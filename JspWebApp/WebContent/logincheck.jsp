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
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
	%>
	<%
		if(uname.equals("First") && password.equals("abc")){
	%>
	<!-- writer.write("<h1>Congratulation! Successfully Logged In</h1>"); -->
		<h1>Congratulation! Successfully Logged In</h1>
		<h2>Hello <%=uname%></h2>
	<% } else { %>
	
	<h1>Sorry! Could not log in</h1>
	<h1>Invalid Credentials!!!</h1>
		
	<% } %>
</body>
</html>