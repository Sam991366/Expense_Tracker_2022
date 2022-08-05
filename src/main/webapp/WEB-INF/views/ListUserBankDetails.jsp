<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
</head>
<body>
	<h2>List Of Bank Details</h2>

	<table border="1">
	
	
	
	
		<tr>
			<th>BANK</th>
			<th>TYPE</th>
			<th>NUMBER</th>
			<th>BALANCE</th>
		
			<th>Action</th>
		</tr>
		
		<c:forEach items="${ubankdetails}" var="u">
			<tr>
				<td>${u.ubank}</td>
				<td>${u.utype}</td>
				<td>${u.ubanknum}</td>
				<td>${u.ubankbal}</td>
				
				<td> <a href="deleteuser?userId">Delete</a> 
					| 
					<a href="viewuser?userId">View</a>
					|
					<a href="edituser?userId">Edit</a>
					
				</td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>