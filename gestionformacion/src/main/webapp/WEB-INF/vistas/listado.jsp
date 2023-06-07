<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Identificador</th>
				<th>Materia</th>
				<th>Fecha</th>
				<th>Horas</th>
				<th>Profesor</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="c">
				<tr>
					<td>${c.id}</td>
					<td>${c.identificador}</td>
					<td>${c.materia.nombre}</td>
					<td>${c.fechaInicio}</td>
					<td>${c.horas}</td>
					<td>${c.profesor.nombre}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td><a href="/formulario">Añadir</a></td>
			</tr>
		</tfoot>
	</table>

</body>
</html>