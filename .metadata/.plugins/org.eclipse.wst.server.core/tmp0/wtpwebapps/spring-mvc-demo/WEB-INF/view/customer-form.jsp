<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Customer Registration Form</title>
	</head>
	<body>
	
		<form:form action ="processForm" modelAttribute="customer">
			
			First Name: <form:input path="firstName"/>
			<br><br>
			Last Name(*) <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
			<br><br>
			Free Passes(*) <form:input path="freePasses"/>
			<form:errors path="freePasses" cssClass="error"/>
			<br><br>
			Postal Code(*)<form:input path ="postal_code" cssClass="error"/>
			<form:errors path="postal_code" cssClass="error"/>
			<br><br>
			Course Code: <form:input path="courseCode"/>
			<form:errors path="courseCode" cssClass="error"/>
			<br><br>
			Associates: 
			<form:input type="text" path = "associates" name="first associate"/>
			<form:input type="text" path = "associates" name="second associate"/>
			<form:input type="text" path = "associates" name="third associate"/>
			<form:input type="text" path = "associates" name="fourth associate"/>
			<form:errors path="associates" cssClass="error"/>
			
			<br><br>
			<input type="submit" value="Submit!"/>
			
			
		</form:form>
		
	</body>
</html>