<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  



<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
	<title>Custom Login Page</title>
	<style>
		.failed {
			color:red;
		}
		.logout{
			color:green;
			background-color:yellow;
		}
	</style>
</head>
<body>
	<h3>My Custom Login Page</h3>
	
	
	
	<form:form action="${pageContext.request.contextPath}/authenticateUsers" method="POST">
		<c:if test="${param.error !=null}">
			<i class="failed"> Custom message: invalid username/password!</i>
		</c:if>
		<c:if test="${param.logout !=null}">
			<i class="logout"> Custom message: You have been logged out!</i>
		</c:if>
		<p>
			<!-- Spring security filter reads the form and checks for the variables "username" and "password" -->
			User name: <input type="text" name="username"/>
		</p>
		<p>
			Password: <input type="password" name="password"/>
		</p>
		<input type="submit" value="Login"/>
	</form:form>
	
	
	
</body>
</html>