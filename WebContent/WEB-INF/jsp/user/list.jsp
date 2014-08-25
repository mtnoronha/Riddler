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
			<div class="well">
				<table class="table">
					<thead>
						<tr>
							<th class="col-sm-4">${i18n.label.name}</th>
							<th class="col-sm-4">${i18n.label.username}</th>
							<th class="col-sm-4">${i18n.label.email}</th>
						</tr>											
					</thead>
					<tbody id="clueTableContent">
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.name}</td>
								<td>${user.username}</td>
								<td>${user.email}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	</body>
</html>