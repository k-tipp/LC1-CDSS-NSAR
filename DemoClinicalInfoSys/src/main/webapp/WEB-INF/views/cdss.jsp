<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="resources/bootstrap/css/bootstrap.css">
<script src="resources/jquery/jquery-1.12.4.js"></script>
<script src="resources/bootstrap/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CDSS4NSAR</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<form role="form" method="POST" enctype="application/json"
				name="CdssRequest">
				<div id="Metadaten" class="form-group">
					<h3>Patientendaten</h3>
					<label for="sex">Geschlecht</label>
					<fieldset>
						<input type="radio" name="Sex" id="male" value="male" /><label
							style="margin-left: 15px;" for="sex">männlich</label> <input
							style="margin-left: 15px;" type="radio" name="Sex" id="female"
							value="female" /><label style="margin-left: 15px;" for="sex">weiblich</label>
						<input style="margin-left: 15px;" type="radio" name="Sex"
							id="other" value="other" /><label style="margin-left: 15px;"
							for="sex">anderes</label>
					</fieldset>
					<label for="heartrate">Alter</label> <input class="form-control"
						type="text" value="55" name="age" /><br>
				</div>
				<div id="Vitalwerte" class="form-group">
					<label for="heartrate">Puls</label> <input class="form-control"
						type="text" value="90" name="heartrate" /> <label for="oxygen">Sauerstoffsättigung</label>
					<input class="form-control" type="text" value=98 name="oxygen" />
					<label for="heartrate">systolischer Blutdruck</label> <input
						class="form-control" type="text" value="125" name="bp_sys" /> <label
						for="heartrate">diastolischer Blutdruck</label> <input
						class="form-control" type="text" value="100" name="bp_dia" /><br>
				</div>
				<div id="Laborwerte" class="form-group">
					<div class="table-responsive">
						<table class="table">
							<thead class="thead-inverse">
								<tr>
									<th>Laborwert</th>
									<th>Normbereich</th>
									<th>Wert</th>
									<th>Einheit</th>
								</tr>
								<tr>
									<td>Kreatinin Serum</td>
									<td>0.6-1.36 mg/dl</td>
									<td><input class="form-control" type="text"
										name="kreatinin_serum" /></td>
									<td>mg/dl</td>
								</tr>
							</thead>
						</table>
					</div>
				</div>
				<button id="submitCdssReq" class="btn btn-primary" type="submit">Send request</button>
			</form>
		</div>
	</div>
</body>
</html>