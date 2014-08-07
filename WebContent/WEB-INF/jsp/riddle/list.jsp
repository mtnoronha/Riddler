<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Riddler</title>
		
		<link href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
	</head>
	
	<body>
		<c:import url="/WEB-INF/jsp/import/menu.jsp"></c:import>
		<div class="container">
			<div class="well">
				<table class="table">
					<thead>
						<tr>
							<th class="col-sm-1">${i18n.label.id}</th>
							<th class="col-sm-10">${i18n.label.description}</th>
							<th class="col-sm-1"></th>
							<th class="col-sm-1"></th>						
						</tr>											
					</thead>
					<tbody id="clueTableContent">
						<c:forEach var="riddle" items="${riddles}">
							<tr>
								<td>${riddle.id}</td>
								<td>${riddle.description}</td>
								<td><a href="${linkTo[RiddleController].index(riddle.id)}" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span></a></td>
								<td><a href="${linkTo[RiddleController].remove(riddle.id)}" class="btn btn-info"><span class="glyphicon glyphicon-remove"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	</body>
</html>