<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
				
		<br> Mobile :<input type="text" name="mobile" /><br>
		<br> Password : <input type="text" name="password" /><br>
		
		<br> <input type="submit" value="Login" />
	</form>
	${msg }
</body>
</html>