<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- lib for looping through list -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>

	<!-- reference the css style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css "/>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2> CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id= "container">
		<div id="content">
			<!-- put new button : Add customer. Onclick calls Spring Controller Mapping method showFormForAdd(). Class regulates the css style -->
			<input type="button" value = "Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class ="add-button"/>
			<!-- add out html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempCustomer12" items="${customers}">
				
					<!--  construct an update link with customer id -->
					<c:url var = "updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer12.id}"/>
					</c:url>
					<!--  construct a delete link with customer id -->
					<c:url var = "deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer12.id}"/>
					</c:url>
						<tr>
							<td> ${tempCustomer12.firstName}</td>
							<td> ${tempCustomer12.lastName}</td>
							<td> ${tempCustomer12.email}</td>
							<!-- to the updateLink we defined in the c:url -->
							<td> 
								<a href = "${updateLink}">Update</a>
								|
								<a href ="${deleteLink}"
								onclick ="if (!(confirm('Are you sure you want to delete?'))) return false"
								>Delete</a>
							</td>
						</tr>
				</c:forEach>
			
			</table>
			
			
		</div>
		
	
	</div>

</body>
</html>