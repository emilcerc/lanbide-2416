<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<fmt:setLocale value="es-ES"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado productos</title>
</head>
<body>

	<table>
		<thead>
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
					<td>
						<fmt:formatNumber type="currency" value="${producto.precio}" />
					</td>
					<td>
						<fmt:parseDate value="${producto.garantia}" pattern="yyyy-MM-dd" var="fecha" type="date"/>
						<fmt:formatDate value="${fecha}"/>
					</td>
					<td>
						<a href="producto?id=${producto.id}">Editar</a>
						<a href="borrar?id=${producto.id}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<a href="producto">Añadir</a>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>