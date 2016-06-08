$(document).ready(function() {
	var additionalMeds;
	
	$("#sendCdssRequest").click(function() {
		$("#cdssRequest").trigger('submit');
	 });

	$("#cdssRequest").submit(function (ev) {
		ev.preventDefault();
		var test = $("#cdssRequest").serialize();
		// something like
		if(additionalMeds != null) {
			test.add(additionalMeds);
		}
		
		alert(test);
	    $.ajax({
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
	        });
	});
	
	$('#newDrugsSave').click(function(e) {
		additionalMeds = $('#newDrugs').value(); // get selected values.
	});
	
	$('#newDrugsAbort').click(function(e) {
		additionalMeds = null;
		$('#newDrugModal').toggle();
	});
	
	
});