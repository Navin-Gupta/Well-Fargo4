<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<% // scriptlet Tag 
			String str = "";
			// part of service : doGet/doPost
		%>

		<%! // declaration tag 
			private String name = ""; // class member
			public void fun(){
				
			}
		%>
		
		<%= // subtitution tag %>
		
		<%--  JSP Comment --%>
		
		<%@  // compilation tag%>
		
		<jsp: // runtime tag /> 
</body>
</html>