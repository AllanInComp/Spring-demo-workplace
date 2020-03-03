<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Save Customer</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customerstyle.css">
	
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer RelationShip Manager</h2>
		
		</div>
	
	</div>
	<div id="container">
	
		<h3> Save Customer</h3>
		<!-- binds data to the model attribute called "customer" in the Customer Controller, relay action to "saveCustomer" method mapping in Spring controller -->\
		<!-- if in update customer, will find any model attribute called "customer" and set fields according to the attribute -->
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<!-- need to associate data with customer id -->
			
			<form:hidden path="id"/> <!-- this line is very important, tracks which customer to form the operation on -->
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="save" class="save"/></td>
					</tr>
				
				</tbody>
			
			</table>
		</form:form>		
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>

</body>
</html>