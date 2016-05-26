<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CDSS4NSAR</title>
</head>
<body>
<div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-4">
<form role="form" method="POST" enctype="application/json" name="CdssRequest">
<div id="Metadaten" class="form-group">
	<label for="sex">Geschlecht</label>
	<fieldset>
	<input type="radio" name="Sex" id="male" value="male" /><label style="margin-left:15px;" for="sex">männlich</label>
	<input style="margin-left:15px;" type="radio" name="Sex" id="female" value="female" /><label style="margin-left:15px;" for="sex">weiblich</label>
	<input style="margin-left:15px;" type="radio" name="Sex" id="other" value="other" /><label style="margin-left:15px;" for="sex">anderes</label>
	</fieldset> 
	<label for="heartrate">Alter</label>
	<input class="form-control" type="text" value="55" name="age" /><br>
</div>
<div id="Vitalwerte" class="form-group">
	<label for="heartrate">Puls</label>
	<input class="form-control" type="text" value="90" name="heartrate" />
	<label for="oxygen">Sauerstoffsättigung</label>
	<input class="form-control" type="text" value=98 name="oxygen" />
	<label for="heartrate">systolischer Blutdruck</label>
	<input class="form-control" type="text" value="125" name="bp_sys" /> 
	<label for="heartrate">diastolischer Blutdruck</label>
	<input class="form-control" type="text" value="100" name="bp_dia" /><br>
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
    	<td><input class="form-control" type="text" name="kreatinin_serum" /></td>
    	<td>mg/dl</td>
    </tr>
    <tr>
    	<td>Kreatinin Urin</td>
    	<td>155-250 mg/dl</td>
    	<td><input class="form-control" type="text" name="kreatinin_urin" /></td>
    	<td>mg/dl</td>
    </tr>
        <tr>
    	<td>Kreatininclearance</td>
    	<td>Frau: 98-156 ml/min<br>Mann: 95-160 ml/min
		</td>
    	<td><input class="form-control" type="text" name="kreatininclearance" /></td>
    	<td>ml/min</td>
    </tr>
  </thead>
  </table>
</div>
</div>
<button class="btn btn-primary" type="submit">Send request</button>
</form>
</div>
</div>
</body>
</html>