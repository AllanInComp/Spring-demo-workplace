<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path = "first_name"/>
		<br><br>
		Last name: <form:input path = "last_name"/>
		<br><br>
		Country:
		<!--  
		<form:select path="country">
			<form:option value = "Brazil" label="Brazil"/>
			<form:option value = "France" label="France"/>
			<form:option value = "Germany" label="Germany"/>
			<form:option value = "India" label="India"/>
			<form:option value = "China" label="China"/>
			<form:option value = "USA" label="USA"/>
		</form:select>
		-->
		<form:select path="country">
			<form:options items= "${student.countryOptions}" />
		</form:select>
		
		<br><br>
		Favorite Language:
		
		Java <form:radiobutton path="favorite_language" value="Java"/>
		C++ <form:radiobutton path="favorite_language" value="C++"/>
		Python <form:radiobutton path="favorite_language" value="Python"/>
		PHP <form:radiobutton path="favorite_language" value="PHP"/>
		Ruby <form:radiobutton path="favorite_language" value="Ruby"/>
		
		<br><br>
		
		MacOS <form:checkbox path="systems_used" value="MacOS" />
		MS Windows<form:checkbox path="systems_used" value="MS Windows" />
		Linux<form:checkbox path="systems_used" value="Linux" />
		<br><br>

		
		
		
		<input type = "submit" value= "Submit!"/>
		
		
		
		
		
	</form:form>
	
</body>
</html>



