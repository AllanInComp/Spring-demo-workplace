<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index file</title>
</head>
<body>
	<h3> Welcome to Spring Rest!</h3>
	<br><br>
	<hr>
	<!-- or a href = "${pageContext.request.contextPath}/test/hello" -->
	<a href="test/hello">Hello</a>
	<hr>
	<a href="api/students">Get All Students</a>
	
</body>
</html>