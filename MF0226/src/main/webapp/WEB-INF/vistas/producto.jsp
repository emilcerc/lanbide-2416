<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="producto" method="post">

	<div class="row mb-3">
		<label class="col-sm-2 col-lg-1 col-form-label" for="id">Id</label>
		<div class="col-sm">
			<input class="form-control" type="number" id="id" name="id" readonly
				value="${producto.id}">
		</div>
	</div>
	<div class="row mb-3">
		<label class="col-sm-2 col-lg-1 col-form-label" for="nombre">Nombre</label>
		<div class="col-sm">
			<input class="form-control" type="text" id="nombre" name="nombre"
				value="${producto.nombre}">
		</div>
	</div>
	<div class="row mb-3">
		<label class="col-sm-2 col-lg-1 col-form-label" for="precio">Precio</label>
		<div class="col-sm">
			<input class="form-control" type="number" step=".01" id="precio" name="precio"
				value="${producto.precio}">
		</div>
	</div>
	<div class="row mb-3">
		<label class="col-sm-2 col-lg-1 col-form-label" for="garantia">Garantía</label>
		<div class="col-sm">
			<input class="form-control" type="date" id="garantia" name="garantia"
				value="${producto.garantia}">
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 offset-lg-1 col-sm">
			<c:if test="${producto.id == null}">
				<button class="btn btn-primary">Añadir</button>
			</c:if>
			<c:if test="${producto.id != null}">
				<button class="btn btn-primary">Modificar</button>
			</c:if>
		</div>
	</div>
</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>