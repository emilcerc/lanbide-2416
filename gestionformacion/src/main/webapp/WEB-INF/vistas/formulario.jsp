<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
<style>
	label {
		display: inline-block;
		width: 7rem;
	}
	
	.error {
		color: red;
	}
	button, .error {
		position: relative;
		left: 7rem;
	}
</style>

</head>
<body>

	<form:form modelAttribute="curso" action="/formulario" method="post">
		<div>
			<form:label path="identificador">Identificador</form:label>
			<form:input placeholder="Identificador" path="identificador" />
			<div class="error">
				<form:errors path="identificador" />
			</div>
		</div>
		<div>
			<form:label path="materia.id">Materia</form:label>
			<form:select path="materia.id">
				<c:forEach items="${materias}" var="m">
					<form:option value="${m.id}">${m.nombre}</form:option>
				</c:forEach>
			</form:select>
			<div class="error">
				<form:errors path="materia.id"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="fechaInicio">Fecha de inicio</form:label>
			<form:input type="date" placeholder="Fecha de inicio"
				path="fechaInicio" />
			<div class="error">
				<form:errors path="fechaInicio"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="horas">Horas</form:label>
			<form:input type="number" placeholder="Horas" path="horas" />
			<div class="error">
				<form:errors path="horas"></form:errors>
			</div>
		</div>
		<div>
			<form:label path="profesor.id">Profesor</form:label>
			<form:select path="profesor.id">
				<c:forEach items="${profesores}" var="p">
					<form:option value="${p.id}">${p.nombre}</form:option>
				</c:forEach>
			</form:select>

			<div class="error" 
				><form:errors path="profesor.id"></form:errors></div>
		</div>

		<button>Guardar</button>
		<div class="error">${error}</div>
	</form:form>
</body>
</html>