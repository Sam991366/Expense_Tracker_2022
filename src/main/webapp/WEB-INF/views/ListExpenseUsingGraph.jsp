<%@page import="com.bean.ExpenseReportBean"%>
<%@page import="com.bean.ExpenseBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="chart-container" style="position: relative; height:30vh; width:40vw">
  <canvas id="myChart"></canvas>
</div>


</body>

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
		        'rgb(255, 205, 86)',
		        'rgb(255, 205, 86)',
		        'rgb(44, 56, 86)',
		        'rgb(11, 45, 86)',
		        'rgb(232, 05, 86)',
		        'rgb(67, 11, 86)',
		        'rgb(55, 44, 86)',
		        'rgb(22, 78, 86)',
		        
		        
		        
		        ],
		      hoverOffset: 4
 	
		 
		   
		    
		  }]
		};

  const config = {
		  type: 'doughnut',
		  data: data,
		  plugins: [plugin],
		};
  
  
  
  
</script>


<script>
  const myChart = new Chart(
    document.getElementById('myChart'),
    config);
</script>


</html>