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
				<div class="col-lg-12 well well-small">
					<select id="riddleSelection" class="form-control">
						<option value="">Select one riddle to analyze</option>
						<c:forEach items="${riddles}" var="riddle">
							<option value="${riddle.value}">${riddle.label}</option>
						</c:forEach>
					</select>										
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<div id="overallChart" data-url="${linkTo[AnalysisController].overall}"></div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<div id="timeChart"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div id="guessesChart"></div>
				</div>
			</div>
			
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="https://www.google.com/jsapi"></script>
		<script src="<c:url value='/js/json2.js'/>"></script>

		 
		<script type="text/javascript">
		    
			var select = $('#riddleSelection');
		
		    // Load the Visualization API and the piechart package.
		    google.load('visualization', '1', {'packages':['corechart']});
		      
		    select.on('change', function () {
		    	var value =	select.val();
		    	
		    	if(value > 0)
		    		drawAll(value);		        
		    });
		    
		    var overallChartContainer = $('#overallChart');
		    var timeChartContainer = $('#timeChart');
		    var guessesChartContainer = $('#guessesChart');

		    function drawAll(riddle){
				console.log(riddle);
	
				$.ajax({
			        url: overallChartContainer.data('url')+riddle,
			        dataType:"json",
			        async: false,
			        success: function(data){			        
						var overall = data.overall;
				        var time = data.time;
						var guesses = data.guesses;
						
				        //Overall Chart			
				        var overallJson = JSON.stringify(overall);
				    	

						var data = new google.visualization.DataTable(overallJson);		
				        var chart = new google.visualization.BarChart(overallChartContainer[0]);
				        chart.draw(data, {title: 'Overall'});		
				        
				        //Time Chart 
				        var timeJson = JSON.stringify(time);
				        
				        var timeData = new google.visualization.DataTable(timeJson);		
				        var timeChart = new google.visualization.BarChart(timeChartContainer[0]);
				        timeChart.draw(timeData, {title: 'Time spent'});	
				        
				        //Guesses Chart 
				        var guessesJson = JSON.stringify(guesses);
				        
				        var guessesData = new google.visualization.DataTable(guessesJson);		
				        var guessesChart = new google.visualization.BarChart(guessesChartContainer[0]);
				        guessesChart.draw(guessesData, {title: 'Number of Answers'});

			        }
		        });				
		    };
			
	    </script>
  	</body>
</html>