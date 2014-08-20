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
			<div class="riddle jumbotron text-center ${riddle == null? 'hidden' : '' }">
				${riddle.description}
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${msg != null}">
						<div class="alert alert-info" role="alert">
						   ${msg.message}<br />
						</div>
					</c:if>
					<c:if test="${clue != null}">
						<div class="alert alert-success" role="alert">
						   ${clue}<br />
						</div>
					</c:if>
					
					<form role="form" class="${riddle == null? 'hidden' : '' }" action="${linkTo[RiddleTestController].answer}" method="post">
						<div class="form-group">
							<label for="answer">${i18n.answer}</label>
							<input type="text" class="form-control" id="answer" name="answer" placeholder="${i18n.type.your.answer}">
						</div>
						<button type="submit" class="btn btn-lg btn-block btn-answer">${i18n.btn.answer}</button>				
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2 pull-right">
					<form role="form" class="${riddle == null? 'hidden' : '' }" action="${linkTo[RiddleTestController].giveup}" method="post">
						<button type="submit" class="btn btn-lg btn-danger">${i18n.btn.giveup}</button>				
					</form>		
				</div>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
	</body>
</html>