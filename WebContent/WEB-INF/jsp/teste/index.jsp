<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Riddler</title>
</head>
<body>
Teste

<c:if test="${msg != null}">
	<h1>${msg}</h1>
</c:if>

<form  action="${linkTo[TesteController].save}" method="post">
	<input type="text" name="obj.id">
	<input type="text" name="obj.test">
	<input value="OK" type="submit">
</form>

</body>
</html>