<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${linkTo[RootController].index}">${i18n.project.name}</a>
		</div>
	
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="menu">
			<ul class="nav navbar-nav">
				<c:if test="${!userWeb.loggedIn}">
					<li><a href="${linkTo[RegisterController].index}">${i18n.menu.register}</a></li>
					<li><a href="${linkTo[LoginController].index}">${i18n.menu.login}</a></li>
				</c:if>

				<c:if test="${userWeb.loggedIn}">
					<li><a href="${linkTo[RiddleTestController].index}">${i18n.menu.riddle.test}</a></li>

					<c:if test="${userWeb.moderator or userWeb.admin}">
						<li><a href="${linkTo[RiddleController].list}">${i18n.menu.riddles}</a></li>
					</c:if>
					
					<li><a href="${linkTo[LoginController].logout}">${i18n.menu.logoff}</a></li>
					
				</c:if>

			</ul>
		</div>
	</div>
</nav>