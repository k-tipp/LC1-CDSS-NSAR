$(document).ready(function() {
	$("#sendCdssRequest").click(function() {
		$("#cdssRequest").trigger('submit');
	 });

	$("#cdssRequest").submit(function (ev) {
		ev.preventDefault();
		var test = $("#cdssRequest").serialize();
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
	        	alert('fail');
	        });
	});
});