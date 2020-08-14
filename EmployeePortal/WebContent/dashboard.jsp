<%@page import="com.wf.training.employee.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Portal : Dashboard</title>
</head>
<body>
	<jsp:include page="header.html"/>
	<%
		// fetch the shared data
		List<Employee> employees =  (List<Employee>) request.getAttribute("employees");
	%>
	<table border="1" width="100%">
		<thead>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>AGE</th>
		</thead>
		<tbody>
			<% for(Employee employee : employees) { %>
			<tr>
				<td><%=employee.getName()%></td>
				<td><%=employee.getEmail()%></td>
				<td><%=employee.getAge()%></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<jsp:include page="footer.jsp"/>
</body>
</html>