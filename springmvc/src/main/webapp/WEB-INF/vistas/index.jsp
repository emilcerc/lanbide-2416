<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<h1>
			Bienvenido
			<sec:authentication property="principal.username" />
		</h1>
	</sec:authorize>
	<form action="${pageContext.request.contextPath}/usuarios/saludar"
		method="post">
		<input name="nombre" placeholder="Nombre">
		<button>Saludar</button>
	</form>

</body>
</html>