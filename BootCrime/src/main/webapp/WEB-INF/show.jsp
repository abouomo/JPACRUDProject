<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crime Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	
	<div class="container mt-5">
		<h2 class="text-center mb-4">Crime Details</h2>
		<c:if test="${crime != null}">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">${crime.description } ${crime.typeOfCrime }</h5>
					<p class="card-text"> 
						<strong>Location:</strong> ${crime.locationOfCrime }<br> 
						<strong>Date:</strong> ${crime.dateOfCrime }
					</p>
				</div>
				<div class="card-body">
					<p class="card-text">
						<strong>Crime investigate by:</strong> ${crime.investigator }
					</p>
				</div>
			</div>
		</c:if>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>