<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${i18n.project.name}</title>
		
		<link href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
	</head>
	
	<body>
		<c:import url="/WEB-INF/jsp/import/menu.jsp"></c:import>
	
		<div class="container">
			<div class="row">
				<div class="jumbotron text-center">
					<h1>Welcome to <b>Codex</b></h1>
					<hr>
					<br>
					<p>What are you looking for ?</p>
				</div>			
			</div>
			<div class="row">
				<div class="well well-small text-center">
					<p>Any questions or suggestion? Send us a message: <a href="mailto:ssolution.codex@gmail.com">ssolution.codex@gmail.com</a></p>
				</div>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
	</body>
</html>