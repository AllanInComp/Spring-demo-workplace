<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation Page</title>
</head>
<body>
	Confirmed customer: ${customer.firstName} ${customer.lastName} 
	<br><br>
	Free passes: ${customer.freePasses}
	<br><br>
	Postal Code: ${postCode}
	<br><br>	
	Course Code: ${customer.courseCode}
	<br><br>	
	Associates:
	<ul>
		<c:forEach var="temp" items= "${customer.associates}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>