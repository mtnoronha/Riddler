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
					<p>We need your help. Your job is to figure out the logic behind each question and give us some feedback. </p>
					<p>This is our testing environment for our questions. Thus, there will be no points or ranking in this enviroment.</p>
					<p>Are you up for the challenge? We hope you have fun.</p>
				</div>			
			</div>
			<c:if test="${!userWeb.loggedIn}">
				<div class="row">
					<a href="${linkTo[RegisterController].index}" class="btn btn-success btn-block btn-lg">${i18n.root.btn}</a>
					<br>
				</div>			
			</c:if>

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