<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="checkBankDetails" method="post" modelAttribute="bank">

		<br> Bank Name 		  : <s:input path="ubank" /><br>
		<br> Pay Mode  		  : 
		<s:select path="utype">
		<s:option value="paytm">Paytm</s:option>
		<s:option value="credit">Credit card</s:option>
		<s:option value="debit">Debit card</s:option>
		</s:select><br>
		<br> A.C Num/Mobile    : <s:input path="ubanknum" /><br>
		
		
		
		<br> <input type="submit" value="Proceed" />
	</s:form>
	${msg }
</body>
</html>