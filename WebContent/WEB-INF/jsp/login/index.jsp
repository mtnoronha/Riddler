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
					<form role="form" action="${linkTo[LoginController].login}" method="post">
						<div class="form-group">
							<label for="username">${i18n.label.username}</label>
							<input type="text" class="form-control" id="username" name="user.username" placeholder="${i18n.type.your.username}">
						</div>
						<div class="form-group">
							<label for="password">${i18n.label.password}</label>
							<input type="password" class="form-control" id="password" name="user.password">
						</div>
						<button type="submit" class="btn btn-lg btn-block btn-success">${i18n.btn.login}</button>				
					</form>
				</div>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
	</body>
</html>