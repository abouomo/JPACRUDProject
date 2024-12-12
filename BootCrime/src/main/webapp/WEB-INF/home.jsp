<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crime</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center mb-4">Crime Lookup</h2>
		<form action="getCrime.do" method="GET" class="mb-4">
			<div class="mb-3">
				<label for="crimeId" class="form-label">Crime ID:</label> <input
					type="text" name="crimeId" id="crimeId" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Show Crime</button>
		</form>

		<div class="list-group">
			<c:forEach var="crime" items="${crimes}">
				<a href="getCrime.do?crimeId=${crime.id }"
					class="list-group-item list-group-item-action">
					${crime.description } </a>
			</c:forEach>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>