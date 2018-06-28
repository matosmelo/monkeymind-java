<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>MonkeyMind</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="../resources/css/materialize.css" type="text/css"
	rel="stylesheet" media="screen,projection" />
<link href="../resources/css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
</head>
<body>

	<!-- Dropdown Structure -->
	<ul id="dropdown1" class="dropdown-content">
		<li><a href="#!">Contato</a></li>
		<li><a href="#!">Sobre</a></li>
		<li class="divider"></li>
		<li><a href="#!">Monkey</a></li>
	</ul>

	<nav class="green">
	<ul id="nav-mobile" class="side-nav">
		<li><a href="<c:url value="/clube/pesquisa"/>">Pesquisa</a></li>
		<li><a href="<c:url value="/clube/novo"/>">Novo clube</a></li>
	</ul>
	<a href="#" data-activates="nav-mobile" class="button-collapse"><i
		class="material-icons">menu</i></a>
	<div class="nav-wrapper green container">
		<a href="<c:url value="/"/>" class="brand-logo">Home</a>
		<ul class="right hide-on-med-and-down">
			<li><a href="<c:url value="/clube/lista"/>">Listar</a></li>
			<li><a href="<c:url value="/clube/pesquisa"/>">Pesquisar</a></li>
			<li><a href="<c:url value="/clube/novo"/>">Novo clube</a></li>
			<li><a class="dropdown-button" href="#!"
				data-activates="dropdown1">Menu<i class="material-icons right">arrow_drop_down</i></a></li>
		</ul>
		</ul>
	</div>
	</nav>
	<div class="row container">
		<c:forEach items="${clubeList}" var="clube">
			<div id="profile-card" class="col m6">
				<div class="card #f5f5f5 grey lighten-4">
					<div class="card-content">
						<img src="../resources/imagens/felipePequeno.jpg" alt=""
							class="circle responsive-img activator card-profile-image">
						<a class="activator btn-move-up waves-effect waves-light right">
							<i class="material-icons black-text">more_vert</i>
						</a> <span class="card-title activator grey-text text-darken-4"><a
							href="<c:url value="/clube/${clube.id}"/>"> ${clube.nome }
						</a></span>

						<p>
							<i class="mdi-action-perm-identity cyan-text text-darken-2"></i>
							Presidente
						</p>
						<p>
							<i class="mdi-action-perm-phone-msg cyan-text text-darken-2"></i>
							${clube.cidade }
						</p>
						<p>
							<i class="mdi-communication-email cyan-text text-darken-2"></i>
							mail@domain.com
						</p>

					</div>
					<div class="card-reveal">
						<span class="card-title grey-text text-darken-4">${clube.nome }<i
							class="mdi-navigation-close right"></i>
						</span>
						<p>Mais informações do clube</p>
						<p>
							<i class="mdi-action-perm-identity cyan-text text-darken-2"></i>
							Presidente
						</p>
						<p>
							<i class="mdi-action-perm-phone-msg cyan-text text-darken-2"></i>
							+5511 9999-9999
						</p>
						<p>
							<i class="mdi-communication-email cyan-text text-darken-2"></i>
							mail@domain.com
						</p>
						<p>
							<i class="mdi-social-cake cyan-text text-darken-2"></i> 21
							Dezembro 1988
						</p>
						<p>
						<form action="<c:url value="/clube/${clube.id}"/>"
							method="POST" class="secondary-content">
							<button class="btn-floating halfway-fab waves-effect waves-light red"
								name="_method" value="DELETE"><i class="material-icons">delete</i></button>

						</form>


					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<footer class="page-footer green">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">MonkeyMind</h5>
				<p class="grey-text text-lighten-4">Tentado fazer a diferença na
					poli­tica.</p>
			</div>

			<div class="col l3 s12">
				<h5 class="white-text">Relacionados</h5>
				<ul>
					<li><a class="white-text" href="#!">Monkey Mind</a></li>
				</ul>
			</div>

			<div class="col l3 s12">
				<h5 class="white-text">Acompanhe</h5>
				<ul>
					<li><a class="white-text" href="#!">Facebook</a></li>
					<li><a class="white-text" href="#!">Twitter</a></li>
					<!-- <li><a class="white-text" href="#!">Linkedin</a></li> -->
				</ul>
			</div>
		</div>
	</div>

	<div class="footer-copyright">
		<div class="container">
			Produzido por <a class="#000000 black-text text-lighten-3"
				href="www.monkeymind.com.br">Monkey Mind Co.</a>
		</div>
	</div>
	</footer>

	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="../resources/js/materialize.js"></script>
	<script src="../resources/js/init.js"></script>
</body>
</html>