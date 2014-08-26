<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${i18n.project.name}</title>
		
		<link href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
	</head>
	
	<body>
		<c:import url="/WEB-INF/jsp/import/menu.jsp"></c:import>
		
		<div class="container">
			<div class="row">
				<div class="chart" data-url="${linkTo[AnalysisController].test}"></div>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="https://www.google.com/jsapi"></script>
		 
		<script type="text/javascript">
		    
		    // Load the Visualization API and the piechart package.
		    google.load('visualization', '1', {'packages':['corechart']});
		      
		    // Set a callback to run when the Google Visualization API is loaded.
		    google.setOnLoadCallback(drawChart);
		      
		    var chartDiv = $('.chart');
		    function drawChart() {
		      var jsonData = $.ajax({
		          url: chartDiv.data('url'),
		          dataType:"json",
		          async: false
		          }).responseText;
		          
		      // Create our data table out of JSON data loaded from server.
		      var data = new google.visualization.DataTable(jsonData);
		
		      // Instantiate and draw our chart, passing in some options.
		      var chart = new google.visualization.PieChart(chartDiv[0]);
		      chart.draw(data, {width: 400, height: 240});
		    }
	
	    </script>
  	</body>
</html>