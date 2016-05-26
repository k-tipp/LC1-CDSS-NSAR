<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CDSS4NSAR</title>
</head>
<body>
<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<form role="form" method="POST" enctype="application/json" name="CdssRequest">
<div class="form-group">
	<label for="heartrate">Puls</label>
	<input class="form-control" type="text" value="90" name="heartrate" />
	<label for="heartrate">systolischer Blutdruck</label>
	<input class="form-control" type="text" value="125" name="bp_sys" /> 
	<label for="heartrate">diastolischer Blutdruck</label>
	<input class="form-control" type="text" value="100" name="bp_dia" />
	<button class="btn btn-default" type="submit">Send request</button>
</div>
</div>
</form>
</div>
</body>
</html>