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
		<c:import url="/WEB-INF/jsp/import/menu.jsp"></c:import>
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
					
					<form role="form" action="${linkTo[RegisterController].register}" method="post">
						<div class="form-group">
							<label for="name">${i18n.label.name}</label>
							<input type="text" class="form-control" id="name" name="user.name" value="${user.name}">
						</div>

						<div class="form-group">
							<label for="username">${i18n.label.username}</label>
							<input type="text" class="form-control" id="username" name="user.username" value="${user.username}" >
						</div>
						
						<div class="form-group">
							<label for="email">${i18n.label.email}</label>
							<input type="email" class="form-control" id="email" name="user.email" value="${user.email}">
						</div>
						
						<div class="form-group">
							<label for="password">${i18n.label.password}</label>
							<input type="password" class="form-control" id="password" name="password">
						</div>

						<button type="submit" class="btn btn-lg btn-block btn-success">${i18n.btn.register}</button>				
					</form>
				</div>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
	</body>
</html>