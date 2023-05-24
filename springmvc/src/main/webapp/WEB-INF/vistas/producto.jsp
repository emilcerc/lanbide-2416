<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	<form:form class="mt-3" action="admin/producto" method="post"
		modelAttribute="producto">
		<div class="row mb-3">
			<form:label path="id" class="col-sm-2 col-form-label">Id</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control"
					cssErrorClass="form-control is-invalid" path="id" placeholder="Id" />
				<div class="invalid-feedback">El id debe ser mayor o igual que
					cero</div>
			</div>
		</div>
		<div class="row mb-3">
			<form:label path="nombre" class="col-sm-2 col-form-label">Nombre</form:label>
			<div class="col-sm-10">
				<form:input type="text" cssClass="form-control"
					cssErrorClass="form-control is-invalid" path="nombre" />
				<div class="invalid-feedback">El nombre debe tener como máximo
					50 caracteres y es obligatorio</div>
			</div>
		</div>
		<div class="row mb-3">
			<form:label path="precio" class="col-sm-2 col-form-label">Precio</form:label>
			<div class="col-sm-10">
				<form:input type="number" step=".01" cssClass="form-control"
					cssErrorClass="form-control is-invalid" path="precio" />
				<div class="invalid-feedback">Debe rellenarse el precio y ser
					mayor o igual que 0</div>
			</div>
		</div>
		<div class="row mb-3">
			<form:label path="caducidad" class="col-sm-2 col-form-label">Caducidad</form:label>
			<div class="col-sm-10">
				<form:input type="date" cssClass="form-control"
					cssErrorClass="form-control is-invalid" path="caducidad" />
				<div class="invalid-feedback">Debe ser una fecha válida y
					futura</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="offset-sm-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Guardar</button>
			</div>
		</div>

	</form:form>

</body>
</html>