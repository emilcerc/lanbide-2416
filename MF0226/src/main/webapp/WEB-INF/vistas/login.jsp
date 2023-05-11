<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="${pageContext.request.contextPath}/login" method="post">

	<div class="row mb-3">
		<label class="col-sm-2 col-lg-1 col-form-label" for="email">Email</label>
		<div class="col-sm">
			<input type="email" class="form-control" id="email" name="email"
				value="${usuario.email}">
		</div>
	</div>
	<div class="row mb-3">
		<label class="col-sm-2 col-lg-1 col-form-label" for="password">Password</label>
		<div class="col-sm">
			<input type="password" class="form-control" id="password"
				name="password" value="${usuario.password}">
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 offset-lg-1 col-sm">
			<button class="btn btn-primary">Login</button>
			<div class="text-danger">${mensaje}</div>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>