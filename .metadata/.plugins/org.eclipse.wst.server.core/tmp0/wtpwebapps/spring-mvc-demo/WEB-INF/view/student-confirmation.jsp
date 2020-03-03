<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- allows looping of list items in jsp -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>
	The Student is confirmed: ${student.first_name} ${student.last_name}
	<br><br>
	Country: ${student.country}
	<br><br>
	Favorite language: ${student.favorite_language}
	<br><br>
	Systems used:
	<ul>
		<c:forEach var="temp" items= "${student.systems_used}">
			<li>${temp}</li>
		</c:forEach>
		
	</ul>
	
	
	
</body>
</html>