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
		<div class="container">
			<div class="riddle jumbotron text-center">
				${i18n.riddle.thank.you}
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<form role="form" action="${linkTo[RiddleTestController].finish}" method="post">
						<input type="hidden" value="${test}" name="test">

						<div class="form-group">
							<label for="comment">${i18n.riddle.comments.about.riddle}</label>
							<textarea id="comment" class="form-control" rows="3" name="comment"></textarea>
						</div>
						<button type="submit" class="btn btn-lg btn-success btn-continue">${i18n.btn.more}</button>				
					</form>
				</div>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
	</body>
</html>