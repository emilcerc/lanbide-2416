<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Producto</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</head>
<body class="container">

	<form class="mt-3" action="${pageContext.request.contextPath}/producto"
		method="post">
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm-10">
				<input type="number"
					class="form-control ${errores.hasFieldErrors('id') ? 'is-invalid' : '' }"
					id="id" name="id" value="${producto.id}" placeholder="Id">
				<div class="invalid-feedback">El id debe ser mayor o igual que
					cero</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm-10">
				<input type="text"
					class="form-control ${errores.hasFieldErrors('nombre') ? 'is-invalid' : '' }"
					id="nombre" name="nombre" value="${producto.nombre}">
				<div class="invalid-feedback">El nombre debe tener como máximo
					50 caracteres y es obligatorio</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm-10">
				<input type="number" step=".01"
					class="form-control ${errores.hasFieldErrors('precio') ? 'is-invalid' : '' }"
					id="precio" name="precio" value="${producto.precio}">
				<div class="invalid-feedback">Debe rellenarse el precio y ser
					mayor o igual que 0</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="caducidad" class="col-sm-2 col-form-label">Caducidad</label>
			<div class="col-sm-10">
				<input type="date"
					class="form-control ${errores.hasFieldErrors('caducidad') ? 'is-invalid' : '' }"
					id="caducidad" name="caducidad" value="${producto.caducidad}">
				<div class="invalid-feedback">Debe ser una fecha válida y
					futura</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="offset-sm-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Guardar</button>
			</div>
		</div>

	</form>

</body>
</html>