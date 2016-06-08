<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css"
	href="/cdss4nsar/resources/bootstrap/css/bootstrap.css">
<script src="/cdss4nsar/resources/jquery/jquery-1.12.4.js"></script>
<script src="/cdss4nsar/resources/bootstrap/js/bootstrap.js"></script>
<script src="/cdss4nsar/controller/result.js"></script>
<script type="text/javascript" src="/cdss4nsar/resources/vis/dist/vis.js"></script>
<link href="/cdss4nsar/resources/vis/dist/vis.css" rel="stylesheet" type="text/css" />
<link href="/cdss4nsar/styles/result.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CDSS4NSAR</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-12 col-md-12">
			<div id="mynetwork"></div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12 col-md-12">
			<table class="table">
				<thead class="thead-inverse">
					<tr>
						<th>Name</th>
						<th>Beschreibung</th>
						<th>Wert</th>
						<th>Typ</th>
						<th>Einheit</th>
						<th>Test</th>
						<th>Objekt 1</th>
						<th>Objekt 2</th>
						<th>Level</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${warnings}" var="warning">
						<tr>
							<td>${warning.name}</td>
							<td>${warning.description}</td>
							<td>${warning.measurementValue}</td>
							<td>${warning.measurementType}</td>
							<td>${warning.measurementUnit}</td>
							<td>${warning.failedTest}</td>
							<td>${warning.conflictObjOne}</td>
							<td>${warning.conflictObjTwo}</td>
							<td>${warning.alertLevel}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>