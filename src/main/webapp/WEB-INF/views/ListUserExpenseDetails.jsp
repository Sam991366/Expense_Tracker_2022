<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Expenses</title>
</head>
<body>
	<h2>List Of Expense Details</h2>

	<table border="1">
	
		<tr>
			<th>Expense Name</th>
			<th>Expense Description</th>
			<th>Expense Amount</th>
			<th>Expense Date</th>
			<th>Expense Time</th>
			<th>Expense From Card</th>
			<th>Expense From Card Number</th>
			<th>Action</th>
		</tr>
		
		<c:forEach items="${ubankdetails}" var="u">
			<tr>
				<td>${u.expname}</td>
				<td>${u.expdes}</td>
				<td>${u.expsum}</td>
				<td>${u.expdate}</td>
				<td>${u.exptime}</td>
				<td>${u.expfrom}</td>
				<td>${u.expfromcard}</td>
				
				<td>  
					| 
					<a href="viewuser?userId">View</a>
					|
					
				</td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>