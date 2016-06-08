$(document).ready(function() {
	var additionalMeds;
	var checkMedication = function() {
		var request = $("#cdssRequest").serialize();
		// something like
		if(additionalMeds != null) {
			request.add(additionalMeds);
		}
		
		alert(request);
	    $.ajax({
	    	crossDomain:true,  
	    	dataType: 'json',
	        type: $("#cdssRequest").attr('method'),
	        url: $("#cdssRequest").attr('action'),
	        enctype: $("#cdssRequest").attr('enctype'),
	        data: request
	    }).success(function (data) {
        	$('#cdssResultView').attr("src", data.resultViewUrl);
        	$('#cdssResultView').css("width", "100%");
        	$('#cdssResultView').css("height", $('#cdssResultModal').height());
        	$('#cdssResultModal').modal('show');
	        }).done(function(data) {
	        	alert('done');
	        }).fail(function(data) {
	        	alert('fail ');
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