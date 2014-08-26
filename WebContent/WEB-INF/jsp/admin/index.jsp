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
				<a href="${linkTo[RiddleController].list}" class="btn btn-info btn-lg">${i18n.admin.shortcut.riddles}</a>
				<a href="${linkTo[UserController].list}" class="btn btn-info btn-lg">${i18n.admin.shortcut.users}</a>
				<a href="${linkTo[AnalysisController].index}" class="btn btn-info btn-lg">${i18n.admin.shortcut.analysis}</a>

			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	</body>
</html>