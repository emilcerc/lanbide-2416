<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MF0226</title>
<!-- BOOTSTRAP -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<script defer
	src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
<!-- FIN BOOTSTRAP -->
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top mb-3">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">MF0226</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/index">Administración</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<main class="container-fluid">