<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-hover table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Garantía</th>
			<th>OPCIONES</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productos}" var="producto">
			<tr>
				<td>${producto.id}</td>
				<td>${producto.nombre}</td>
				<td><fmt:formatNumber type="currency"
						value="${producto.precio}" /></td>
				<td><fmt:parseDate value="${producto.garantia}"
						pattern="yyyy-MM-dd" var="fecha" type="date" /> <fmt:formatDate
						value="${fecha}" /></td>
				<td><a class="btn btn-sm btn-primary" href="producto?id=${producto.id}">Editar</a> <a
					class="btn btn-sm btn-danger" href="borrar?id=${producto.id}">Borrar</a></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-sm btn-primary" href="producto">Añadir</a></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>