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
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>