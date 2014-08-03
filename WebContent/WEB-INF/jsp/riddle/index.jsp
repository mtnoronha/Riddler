<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Riddler</title>
		
		<link href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
		<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${errors != null}">
						<div class="alert alert-danger" role="alert">
							<c:forEach var="error" items="${errors}">
							   ${error.message}<br />
							</c:forEach>
						</div>
					</c:if>
					
					<form role="form" action="${linkTo[RiddleController].save}" method="post">
						<input type="hidden" name="riddle.id" value="${riddle.id}">
												
						<div class="form-group">
							<label for="description">${i18n.label.description}</label>
							<textarea rows="5"  class="form-control" id="description" name="riddle.description">${riddle.description}</textarea>
						</div>

						<div class="form-group">
							<label for="answer">${i18n.label.answer}</label>
							<input type="text" class="form-control" id="answer" name="riddle.answer" value="${riddle.answer}">
						</div>


						<div class="form-group">
							<label for="reward">${i18n.label.reward}</label>
							<input type="text" class="form-control" id="reward" name="riddle.reward" value="${riddle.reward}">
						</div>

						<div class="form-group">
							<label for="level">${i18n.label.level}</label>
							<input type="text" class="form-control" id="level" name="riddle.level" value="${riddle.level}">
						</div>

						<button type="submit" class="btn btn-lg btn-block btn-success">${i18n.btn.save}</button>				
					</form>
				</div>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
	</body>
</html>