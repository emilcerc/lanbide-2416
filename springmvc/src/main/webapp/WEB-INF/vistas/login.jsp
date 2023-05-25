<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!-- JSP -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Producto</title>

<base href="${pageContext.request.contextPath}/">

<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.bundle.min.js"></script>
</head>
<body class="container">
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username"/>
	</sec:authorize>

	<c:if test="${param.error != null}">
		<div>El usuario o contraseña no son correctos</div>
	</c:if>

	<c:if test="${param.logout != null}">
		<div>El usuario ha cerrado sesión</div>
	</c:if>

	<form class="mt-3" action="login" method="post">
		<div class="row mb-3">
			<label for="user" class="col-sm-2 col-form-label">Usuario</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="user" name="username"
					placeholder="Usuario" />
			</div>
		</div>
		<div class="row mb-3">
			<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="Contraseña" />
			</div>
		</div>
		<div class="row mb-3">
			<div class="offset-sm-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
		</div>

	</form>
</body>
</html>