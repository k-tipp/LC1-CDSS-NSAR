<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Title of document</title>

<link rel="stylesheet" type="text/css"
	href="/demoCIS/resources/bootstrap/css/bootstrap.css">
<link href="/demoCIS/resources/styles/main.css" rel="stylesheet" />
<link href="/demoCIS/resources/styles/sidebar.css" rel="stylesheet" />
<link href="/demoCIS/resources/styles/patient.css" rel="stylesheet" />

<script src="/demoCIS/resources/jquery/jquery-1.12.4.js"></script>
<script src="/demoCIS/resources/bootstrap/js/bootstrap.js"></script>
<script src="/demoCIS/controller/patient.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CDSS4NSAR</title>
</head>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="home.html">MY PDMS</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/demoCIS/patient">Home</a></li>
					<c:if test="${not empty activePatient}">
						<li><a id="nav-patient"
							href="/demoCIS/patient/${activePatient.patientId}">&gt;
								Patient: ${activePatient.firstname} ${activePatient.lastname}</a></li>
					</c:if>
				</ul>
				<!-- 				<div class="navbar-right"> -->
				<!-- 					<ul class="nav navbar-nav"> -->
				<!-- 						<li><a href="../server/logout.php"> <span -->
				<!-- 								class="glyphicon glyphicon-log-out" aria-hidden="true"></span> -->
				<!-- 								Logout -->
				<!-- 						</a></li> -->
				<!-- 					</ul> -->
				<!-- 				</div> -->
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar" id="patients">
					<c:forEach items="${patients}" var="patient" varStatus="status">
						<c:choose>
							<c:when test="${patient.patientId eq activePatient.patientId}">
								<li class="active"><a
									href="/demoCIS/patient/${patient.patientId}">${patient.firstname}
										${patient.lastname}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/demoCIS/patient/${patient.patientId}">${patient.firstname}
										${patient.lastname}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
			<div class="col-xs-9 col-xs-offset-3 col-md-10 col-md-offset-2">
				<c:choose>
					<c:when test="${empty activePatient}">
						<h1>&lt;-- Choose a patient</h1>
					</c:when>
					<c:otherwise>
						<form role="form" method="POST" enctype="application/json"
							name="CdssRequest" id="cdssRequest">
							<input type="hidden" name="patientId"
								value="${activePatient.patientId}" />
							<div class="row">
								<div class="col-xs-8 col-md-9">
									<h1 id="page-title">Patient: ${activePatient.firstname}
										${activePatient.lastname}</h1>
									<div class="patient-form form-inline">
										<lable><b>Sex: </b></label>
										<select class="form-control">
										  <option>male</option>
										  <option>female</option>
										  <option>unknown</option>
										</select>
										<label> &nbsp;&nbsp;Age: </label>
										 <input type="number" name="patAge" id="patAge" class="form-control" />
										 <label class="checkbox-inline">
										  <input type="checkbox" name="isPregnant" value="isPregnant"><b>is pregnant &nbsp;&nbsp;</b>
										</label>
										<label>Allergics: </label>
										<select multiple class="form-control" id="patAllergics">
					                       <c:forEach items="${drugs}" var="drug">
									           <option value="${drug.name}">${drug.name}</option>
									       </c:forEach>
									      </select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-5 col-md-5">
									<button class="btn btn-info btn-lg" id="sendCdssRequest"
										type="button">Check Medication</button>
									<h2>Current medication:</h2>
									<c:forEach items="${activePatient.medications}"
										var="medication" varStatus="status">
										<div class="panel panel-info">
											<div class="panel-heading">
												<h3 class="panel-title">${medication.medicationDescription}</h3>
											</div>
											<div class="panel-body">
												<table class="table table-condensed table-hover">
													<thead>
														<tr>
															<th>ID</th>
															<th>Name</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${medication.drugList}" var="drug">
															<tr>
																<td>${drug.drugId}</td>
																<td>${drug.name}<input type="hidden"
																	name="patDrug[]" value="${drug.name}" /></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</c:forEach>
								</div>
								<div class="col-xs-4 col-md-5">
									<button class="btn btn-info btn-lg" id="newMedication"
										type="button">New Medication</button>
									<h2>Laboratory Results:</h2>
									<div class="panel panel-info">
										<div class="panel-heading">
											<h3 class="panel-title">Laboratory Results</h3>
										</div>
										<div class="panel-body">
											<table class="table table-condensed table-hover">
												<thead>
													<tr>
														<th>ID</th>
														<th>Name</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${activePatient.labResults}" var="result">
														<tr>
															<td>${result.labResultId}</td>
															<td id="labType">${result.type}<input type="hidden"
																name="labType[]" value="${result.type}" /></td>
															<td id="labValue">${result.value}<input
																type="hidden" name="labValue[]" value="${result.value}" /></td>
															<td id="labSize">${result.measuringSize}<input
																type="hidden" name="labSize[]"
																value="${result.measuringSize}" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>

</html>
