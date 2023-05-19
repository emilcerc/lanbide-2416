<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hover table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Título</th>
			<th>Grupo</th>
			<th>Estilo</th>
			<th>Enlace</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${canciones}" var="c">
			<tr>
				<th>${c.id}</th>
				<td>${c.titulo}</td>
				<td>${c.grupo}</td>
				<td>${c.estilo.nombre}</td>
				<td><a class="btn btn-primary" href="${c.enlace}"><i class="bi bi-play"></i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form action="${pageContext.request.contextPath}/usuario/principal" method="post">
	<div class="row mb-3">
		<label for="titulo" class="col-sm-2 col-form-label">Título</label>
		<div class="col-sm">
			<input type="text" class="form-control" id="titulo" name="titulo">
		</div>
	</div>
	<div class="row mb-3">
		<label for="grupo" class="col-sm-2 col-form-label">Grupo</label>
		<div class="col-sm">
			<input type="text" class="form-control" id="grupo" name="grupo">
		</div>
	</div>
	<div class="row mb-3">
		<label for="estilo" class="col-sm-2 col-form-label">Estilo</label>
		<div class="col-sm">
			<select class="form-select" id="estilo" name="estilo">
				<c:forEach items="${estilos}" var="e">
					<option value="${e.id}">${e.nombre}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="row mb-3">
		<label for="enlace" class="col-sm-2 col-form-label">Enlace</label>
		<div class="col-sm">
			<input type="url" class="form-control" id="enlace" name="enlace">
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>
</form>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>