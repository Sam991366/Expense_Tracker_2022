<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
</head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<body>
<s:form action="saveuser" method="post" modelAttribute="user">

		<br> FirstName : <s:input path="firstname" /><br>
		<br> Email     : <s:input path="email" /><br>
		<br> Mobile    : <s:input path="mobile" /><br>
		<br> Password  : <s:input path="password" /><br>
		
		<br> Gender    : 
			    Male <s:radiobutton path="gender" value="male"/>
				Female <s:radiobutton path="gender" value="female"/>
		<br> <input type="submit" value="Signup" />
	</s:form>
	${msg }
</body>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
</html>