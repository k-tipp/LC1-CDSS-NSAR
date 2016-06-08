$(document).ready(function() {
	var additionalMeds;
	var checkMedication = function() {
		var test = $("#cdssRequest").serialize();
		// something like
		if(additionalMeds != null) {
			test.add(additionalMeds);
		}
		
		alert(test);
	    $.ajax({
	    	crossDomain:true,  
	    	dataType: 'json',
	        type: $("#cdssRequest").attr('method'),
	        url: $("#cdssRequest").attr('action'),
	        enctype: $("#cdssRequest").attr('enctype'),
	        data: test
	    }).success(function (data) {
	            alert('ok');
	        }).done(function(data) {
	        	alert('done');
	        }).fail(function(data) {
	        	alert('fail ' + data);
	        	$('#cdssResultView').attr("src", "http://localhost:8080/cdss4nsar/result/1");
	        	$('#cdssResultView').css("width", "100%");
	        	$('#cdssResultView').css("height", $('#cdssResultModal').height());
	        	$('#cdssResultModal').modal('show');
	        });
	};
	
	
	$("#sendCdssRequest").click(function() {
		$("#cdssRequest").trigger('submit');
	 });

	$("#cdssRequest").submit(function (ev) {
		ev.preventDefault();
		checkMedication();
		
	});
	
	$('#newDrugsSave').click(function(e) {
		additionalMeds = $('#newDrugs').value(); // get selected values.
		$('#newDrugModal').toggle();
	});
	
	$('#newDrugsAbort').click(function(e) {
		additionalMeds = null;
		$('#newDrugModal').toggle();
	});
	
	
});