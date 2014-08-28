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
				<div class="jumbotron text-center">
					<div class="row">
						<h1>Welcome to <b>Codex</b></h1>
					</div>
					<hr>
					<c:if test="${!userWeb.loggedIn}">
						<p>We need your help. Your job is to figure out the logic behind each question and give us some feedback. </p>
						<p>This is our testing environment for our questions. Thus, there will be no points or ranking in this environment.</p>
						<p>Are you up for the challenge? We hope you have fun.</p>
					</c:if>
					<c:if test="${userWeb.loggedIn}">
						<p>This game is about logic. You have to follow the clues and figure out the "key" to unlock the next question.</p>
						<p>There are logical questions, cryptography, research, riddles, math... All you can think of.</p>
						<p>Here's a tip: try to find a logical or related answer. Search, and think hard.</p>
						<p>Most importantly: <b>follow the clues</b>. Good luck.</p>
					</c:if>
					<div class="row">
						<c:if test="${!userWeb.loggedIn}">
							<div class="col-lg-6">
								<a href="${linkTo[RegisterController].index}" class="btn btn-success btn-block btn-lg">Challenge Accepted (register)</a>
								<br>
							</div>			
							
							<div class="col-lg-6">
								<a href="${linkTo[LoginController].index}" class="btn btn-info btn-block btn-lg">Continue (login)</a>
							</div>			
						</c:if>
						<c:if test="${userWeb.loggedIn}">						
							<div class="col-lg-12">
								<a href="${linkTo[RiddleTestController].index}" class="btn btn-success btn-block btn-lg">Start testing</a>
							</div>			
						</c:if>		
					</div>

					<p><small>Any questions or suggestion? Send us a message: <a href="mailto:ssolution.codex@gmail.com">ssolution.codex@gmail.com</a></small></p>
				</div>			
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
	</body>
</html>