<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Portal : New Employee</title>
</head>
<body>
<jsp:include page="header.html"/>

<form action="employee?action=save" method="post">
	<div>
		<div><label>Enter name</label> <input type="text" name="ename"></div>
		<br/>
		<div><label>Enter email</label> <input type="text" name="email"></div>
		<br/>
		<div><label>Enter age</label> <input type="text" name="age"></div>
		<div> <input type="submit" value="Add"> </div>
	</div>
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>