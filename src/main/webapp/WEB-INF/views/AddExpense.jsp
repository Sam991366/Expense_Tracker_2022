<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
</head>
<body>
<form action="addExpense" method="post" >
				
			 Expense Name        :<input type="text" name="expname" /><br>
		<br> Expense Description :<input type="text" name="expdes" /><br>
		<br> Expense Total       :<input type="number" name="expsum" /><br>
		<br> Expense Date        :<input type="date" name="expdate"  /><br>
		<br> Expense Time        :<input type="time" name="exptime"/><br>
		<br>
		<label>Payment from:</label>
  		<select name="expfrom" id="expfrom" >
    	<option value="paytm">Paytm</option>
    	<option value="credit">Credit Card</option>
   	 	<option value="debit">Debit Card</option>
  		</select>
  		<br> Expense Card        :<!-- <input type="number" name="expfromcardnum"/> -->
  		<select name="expfromcardnum" id="expfromcardnum">
    	
  		</select><br>
			<br><br>
		<br> <input type="submit" value="Proceed" />
	</form>

<script>

$(document).ready(function(){
	$("#expfrom").change(function(){
		var name = document.getElementById("expfrom").value;
				let url = "http://localhost:9590/carddetail?expfrom="+name;	
				 	 
				$.get(url)
				.done(function(data){
					console.log(data);
					let accounts = $("#expfromcardnum");
					accounts.empty();
					for(let i=0;i<data.length;i++){ 
						 accounts.append("<option value="+data[i].ubanknum+">"+data[i].ubank+" "+data[i].ubanknum+" - Balance:"+data[i].ubankbal+"</option>"); 
						//value ma je hoy ej database laie jayy biju bandhun print karva mate hoy
					}
					
				}).fail(function(){
					console.log("something went wrong in accType AJAX"); 
				});
	})	
})

</script>

</body>


</html>