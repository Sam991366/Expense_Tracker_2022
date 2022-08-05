<%@page import="java.util.List"%>
<%@page import="com.bean.ExpenseReportBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="addExpense">EXPENSE TRACKER</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="addExpense">ADD EXPENSE</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="listExpensesByUserId">VIEW ALL EXPENSE</a>
     	</li>
 		   <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="addBankDetails">ADD BANK DETAILS</a>
     	</li>
     	
     	<li>
 		   <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="listbankdetailsofuser">SHOW ALL BANK DETAILS</a>
     	</li>
     	
        <li>
 		   <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="myChart">SHOW EXPENSES WITH GRAPH</a>
     	</li>
          <li class="nav-item dropdown">
          <a class="nav-link active dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            INCOME
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="#">ADD INCOME</a></li>
            <li><a class="dropdown-item" href="#">VIEW INCOME</a></li>
            <li><a class="dropdown-item" href="#">Debit Card</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
${msg}

<div class="chart-container" style="position: relative; height:30vh; width:40vw">
  <canvas id="myChart"></canvas>
</div>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<%List<ExpenseReportBean> expenses = (List<ExpenseReportBean>) request.getAttribute("expenses");%>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
const data = {
		  labels: [
			  
			  
			  <%for (ExpenseReportBean cr : expenses) {%>
				'<%=cr.getExpdes()%>',
			<%}%>
			
			
		  ],
		  datasets: [{
		    label: 'My First Dataset',
		   
		    data: [
		    	
		    	<%for (ExpenseReportBean cr : expenses) 
		    	{
		    	%>
				<%=cr.getTotalprice()%>,
			<%}%> ],
		    	
		    	
		    backgroundColor: [
		        'rgb(255, 99, 132)',
		        'rgb(54, 162, 235)',
		        'rgb(255, 205, 86)'
		      ],
		      hoverOffset: 4
 	
		 
		   
		    
		  }]
		};

  const config = {
		  type: 'doughnut',
		  data: data,
		};
</script>


<script>
  const myChart = new Chart(
    document.getElementById('myChart'),
    config);
</script>


</html>